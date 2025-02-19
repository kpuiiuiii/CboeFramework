package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.project.utilities.Driver;

public class CboeHomePage {

    public CboeHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Cookie Consent (if needed)
    @FindBy(xpath = "//button[@data-cky-tag='close-button']")
    // Replace with actual ID
    private WebElement cookiesCloseButton;

    @FindBy(xpath = "//section[@class='hero hero--diamonds']//a[@href='/insights/']")
    private WebElement insightsLink;

    @FindBy(xpath = "//button[@id='search--button']")
    private WebElement searchButtonField;

    @FindBy(xpath = "//form[@id='search--form']//div[@class='ReactSelect__control css-13cymwt-control']")
    private WebElement searchTextField;

    @FindBy(xpath = "//div[contains(text(), 'https://www.cboe.com/delayed_quotes/vix/')]")
    private WebElement vixLink;

    @FindBy(xpath = "//div[@class='ReactSelect__control ReactSelect__control--is-focused ReactSelect__control--menu-is-open css-t3ipsp-control']")
    private WebElement searchTextFieldFocused;

    @FindBy(xpath = "//*[@id=\"site-nav\"]/ul/li[2]/a")
    private WebElement cboeDataVantageLink;

    @FindBy(xpath = "//span[contains(text(), 'Quotes Dashboard')]")
    private WebElement quotesDashboardLink;

    public WebElement getCookiesCloseButton() {
        return cookiesCloseButton;
    }

    public WebElement getInsightsLink() {
        return insightsLink;
    }

    public WebElement getSearchField() {
        return searchButtonField;
    }

    public WebElement getSearchTextField() {
        return searchTextField;
    }

    public WebElement getVixLink() {
        return vixLink;
    }

    public WebElement getSearchTextFieldFocused() {
        return searchTextFieldFocused;
    }

    public WebElement getCboeDataVantageLink() {
        return cboeDataVantageLink;
    }

    public WebElement getQuotesDashboardLink() {
        return quotesDashboardLink;
    }
}