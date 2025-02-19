package com.project.step_definitions;

import com.github.javafaker.Faker;
import com.project.pages.CboeHomePage;
import com.project.pages.ContactUsPage;
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


public class CboeContactUsStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(CboeContactUsStepDefinitions.class);

    private final WebDriver driver;
    private final ContactUsPage contactUsPage;
    private final CboeHomePage homePage;
    private final WebDriverWait wait;
    private final Faker faker;

    public CboeContactUsStepDefinitions() {
        driver = Driver.getDriver();
        contactUsPage = new ContactUsPage();
        homePage = new CboeHomePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        faker = new Faker();

    }

    // Constants
    private static final String CONTACT_US_URL;

    static {
        try {
            URI baseUri = new URI(ConfigurationReader.getProperty("base_url") + "/contact/");
            CONTACT_US_URL = baseUri.toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid base URL: " + ConfigurationReader.getProperty("base_url"), e);
        }
    }

    @Given("I am on the Cboe Contact Us page")
    public void i_am_on_the_cboe_contact_us_page() {
        logger.info("Navigating to Cboe Contact Us page: {}", CONTACT_US_URL);
        driver.get(CONTACT_US_URL);

        // Handle cookie consent (if present)
        try {
            WebElement cookiesCloseButton = wait.until(ExpectedConditions.visibilityOf(homePage.getCookiesCloseButton()));
            cookiesCloseButton.click();
            logger.info("Cookies accepted.");
        } catch (Exception e) {
            logger.info("Cookie consent banner not found or already accepted.");
        }
    }

    @When("I fill in the contact form with valid information")
    public void i_fill_in_the_contact_form_with_valid_information() {
        logger.info("Filling in contact form with Faker data.");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().phoneNumber();
        String message = faker.lorem().sentence(5);
        String company = faker.company().name();
        String subject = faker.lorem().sentence(2);

        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getFirstNameInput())).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getLastNameInput())).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getEmailInput())).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getPhoneNameInput())).sendKeys(phone);

        wait.until(ExpectedConditions.elementToBeClickable(contactUsPage.getTopicDropdownArrowButton())).click();
        contactUsPage.getDropdownCareersOption().click();

        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getCompanyInput())).sendKeys(company);
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getSubjectInput())).sendKeys(subject);
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getMessageInput())).sendKeys(message);

        logger.info("Contact form filled.");
    }

    @When("I submit the contact form")
    public void i_submit_the_contact_form() {
        logger.info("Submitting the contact form.");
        wait.until(ExpectedConditions.elementToBeClickable(contactUsPage.getSubmitButton()));
        contactUsPage.getSubmitButton().click();
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String expectedErrorMessage) {
        logger.info("Verifying error message: {}", expectedErrorMessage);
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getEmailErrorMessage()));
        Assert.assertEquals("Error message text check", expectedErrorMessage, contactUsPage.getEmailErrorMessage().getText());
    }

    @Then("I should see a success message saying {string}")
    public void i_should_see_a_success_message_saying(String expectedMessage) {
        logger.info("Verifying the fail message: {}", expectedMessage);
        Assert.assertEquals("Checking if success message is displayed", expectedMessage, contactUsPage.getEmailErrorMessage().getText());
    }
}