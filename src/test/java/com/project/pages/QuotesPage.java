package com.project.pages;

import com.project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QuotesPage{

    public QuotesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='txtSymbol']")
    private WebElement symbolInputTextField;

    @FindBy(xpath = "//button[@type='button']/span[contains(text(), 'Search')]")
    private WebElement symbolSearchButton;

    @FindBy(xpath = "//*[@id=\"quote_table\"]/span")
    private WebElement optionsNavButton;

    @FindBy(xpath = "//div[contains(@class, 'AOyXR')]")
    private List<WebElement> optionsChainTables;

    @FindBy(xpath = "(//div[contains(text(), 'Calls')])[1]")
    private WebElement callsHeader;

    @FindBy(xpath = "(//div[contains(text(), 'Puts')])[1]")
    private WebElement putsHeader;

    @FindBy(xpath = "(//div[contains(@class, 'AOyXR')])[1]//div[contains(@class, 'grYzkZ')]")
    private List<WebElement> strikePriceElements;

    @FindBy(xpath = "//div[@class='Box-cui__sc-6h7t1h-0 Text-cui__sc-1owhlvg-0 OptionsMontage___StyledText14-sc-18azjpu-13 fyQjgl NWjjs bbYRKX']")
    private List<WebElement> allBids;

    @FindBy(xpath = "//div[@class='Box-cui__sc-6h7t1h-0 Text-cui__sc-1owhlvg-0 OptionsMontage___StyledText14-sc-18azjpu-13 fyQjgl NWjjs bbYRKX']")
    private List<WebElement> allAsks;


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

    public List<WebElement> getAllBids() {
        return allBids;
    }

    public List<WebElement> getAllAsks() {
        return allAsks;
    }






}