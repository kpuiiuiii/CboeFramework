package com.project.step_definitions;

import com.project.pages.CboeHomePage;
import com.project.pages.QuotesPage;
import com.project.utilities.ConfigurationReader;
import com.project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CboeQuotesStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(CboeQuotesStepDefinitions.class);

    private final WebDriver driver;
    private final CboeHomePage homePage;
    private final QuotesPage quotesPage;
    private final WebDriverWait wait;

    public CboeQuotesStepDefinitions() {
        driver = Driver.getDriver();
        quotesPage = new QuotesPage();
        homePage = new CboeHomePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Constants
    private static final String CBOE_HOME_URL;

    static {
        try {
            URI baseUri = new URI(ConfigurationReader.getProperty("base_url"));
            CBOE_HOME_URL = baseUri.toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid base URL: " + ConfigurationReader.getProperty("base_url"), e);
        }
    }



    @Given("market analyst {string} is on the Cboe homepage")
    public void market_analyst_is_on_the_cboe_homepage(String traderName) {
        logger.info("{} is on the Cboe homepage.", traderName);
        driver.get(CBOE_HOME_URL);

        // Handle cookie
        try {
            WebElement cookiesCloseButton = wait.until(ExpectedConditions.visibilityOf(homePage.getCookiesCloseButton()));
            cookiesCloseButton.click();
            logger.info("Cookies accepted.");
        } catch (Exception e) {
            logger.info("Cookie consent banner not found or already accepted.");
        }
    }

    @When("navigates to the {string} section")
    public void navigates_to_the_section(String section) {
        logger.info("Navigating to the '{}' section.", section);

        wait.until(ExpectedConditions.visibilityOf(homePage.getCboeDataVantageLink()));
        homePage.getCboeDataVantageLink().click();

        wait.until(ExpectedConditions.visibilityOf(homePage.getQuotesDashboardLink()));
        homePage.getQuotesDashboardLink().click();


    }

    @When("enters the symbol {string} for the S&P 500 Index")
    public void enters_the_symbol_for_the_s_p_index(String symbol) {
        logger.info("Entering symbol: {}", symbol);

        wait.until(ExpectedConditions.visibilityOf(quotesPage.getSymbolInput()));
        quotesPage.getSymbolInput().clear();
        quotesPage.getSymbolInput().sendKeys(symbol);

        wait.until(ExpectedConditions.elementToBeClickable(quotesPage.getSymbolSearchButton()));
        quotesPage.getSymbolSearchButton().click();
    }

    @Then("the options chain tables should be displayed")
    public void the_options_chain_table_should_be_displayed() {
        logger.info("Verifying options chain table is displayed.");

        wait.until(ExpectedConditions.elementToBeClickable(quotesPage.getOptionsNavButton()));
        quotesPage.getOptionsNavButton().click();

        wait.until(ExpectedConditions.visibilityOf(quotesPage.getOptionsChainTables().getFirst()));

        Assert.assertFalse("Options chain table should be displayed", quotesPage.getStrikePriceElements().isEmpty());
    }

    @Then("the table should include columns for {string} and {string}")
    public void the_table_should_include_columns_for_and(String calls, String puts) {
        logger.info("Verifying table columns for '{}' and '{}'.", calls, puts);

        wait.until(ExpectedConditions.visibilityOf(quotesPage.getCallsHeader()));
        wait.until(ExpectedConditions.visibilityOf(quotesPage.getPutsHeader()));

        Assert.assertTrue(calls + " column should be displayed", quotesPage.getCallsHeader().isDisplayed());
        Assert.assertTrue(puts + " column should be displayed", quotesPage.getCallsHeader().isDisplayed());
    }

    @Then("the strike prices should be listed in ascending order")
    public void the_strike_prices_should_be_listed_in_ascending_order() {
        logger.info("Verifying 'Strike' prices are in ascending order.");

        wait.until(ExpectedConditions.visibilityOfAllElements(quotesPage.getStrikePriceElements()));
        List<Double> strikePrices = new ArrayList<>();

        // Parse strike prices from text and add to list
        for (WebElement element : quotesPage.getStrikePriceElements()) {
            String priceText = element.getText().replace(",", "");
            priceText = priceText.substring(priceText.indexOf(" "));
            logger.info("Strike price: {}", priceText);
            try {
                strikePrices.add(Double.parseDouble(priceText));
            } catch (NumberFormatException e) {
                logger.error("Failed to parse strike price: {}", priceText, e);
                Assert.fail("Failed to parse strike price: " + priceText);
            }
        }

        // Check if sorted
        for (int i = 0; i < strikePrices.size() - 1; i++) {
            if (strikePrices.get(i) > strikePrices.get(i + 1)) {
                Assert.fail("Strike prices are not in ascending order.  " +
                        strikePrices.get(i) + " is greater than " + strikePrices.get(i + 1));
            }
        }
    }

    @Then("bid and ask prices should be visible for each option")
    public void bid_and_ask_prices_should_be_visible_for_each_option() {
        logger.info("Verifying 'Bid' and 'Ask' prices are displayed.");

        List<WebElement> listOfBinsAndAsks = quotesPage.getAllAsks();
        listOfBinsAndAsks.addAll(quotesPage.getAllBids());

        // Check if Bid and Ask prices are displayed
        for (WebElement entry : listOfBinsAndAsks) {
            Assert.assertTrue("Bid price should be displayed", entry.isDisplayed());
        }
    }

}