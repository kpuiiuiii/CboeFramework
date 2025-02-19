package com.project.pages;

import com.project.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QuotesPage{

    public QuotesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locators for elements on the Quotes page
    @FindBy(xpath = "//input[@name='txtSymbol']")
    private WebElement symbolInputTextField;

    @FindBy(xpath = "//button[@type='button']/span[contains(text(), 'Search')]")
    private WebElement symbolSearchButton;

    @FindBy(xpath = "//*[@id=\"quote_table\"]/span")
    private WebElement optionsNavButton;

    @FindBy(xpath = "//div[contains(@class, 'AOyXR')]")
    private List<WebElement> optionsChainTables;


    @FindBy(xpath = "(//div[contains(@class, 'AOyXR')])[1]//div[contains(text(), 'Calls')]")
    private WebElement callsHeader;
    @FindBy(xpath = "(//div[contains(@class, 'AOyXR')])[1]//div[contains(text(), 'Puts')]")
    private WebElement putsHeader;

    @FindBy(xpath = "(//div[contains(@class, 'AOyXR')])[1]//div[contains(@class, 'grYzkZ')]")
    private List<WebElement> strikePriceElements;

    //Locators for table rows, bid and ask prices
    private final By tableRows = By.xpath("//table[@id='optionsChainTable']//tr"); //Locate all table rows
    private final By bidPriceLocator = By.xpath(".//td[6]"); //Locate bid price by position (6th column)
    private final By askPriceLocator = By.xpath(".//td[8]"); //Locate ask price by position (8th column)



    //Methods to get the elements
    public WebElement getSymbolInput() {
        return symbolInputTextField;
    }

    public WebElement getSymbolSearchButton() {
        return symbolSearchButton;
    }

    public WebElement getOptionsNavButton() {
        return optionsNavButton;
    }



    public List<WebElement> getOptionsChainTables() {
        return optionsChainTables;
    }

    public WebElement getCallsHeader() {
        return callsHeader;
    }

    public WebElement getPutsHeader() {
        return putsHeader;
    }

    public List<WebElement> getStrikePriceElements() {
        return strikePriceElements;
    }

    public By getTableRows() {
        return tableRows;
    }

    public By getBidPriceLocator() {
        return bidPriceLocator;
    }

    public By getAskPriceLocator() {
        return askPriceLocator;
    }
}