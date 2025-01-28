package com.project.pages;

import com.project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {


    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='cky-consent-bar']//button[contains(text(), 'Accept All')]")
    public WebElement cookiesAcceptButton;

    @FindBy(xpath = "//input[@name='first_name']")
    public  WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='phone_number']")
    public WebElement phoneNameInput;

    @FindBy(xpath = "//form[@action='submit/']//*[local-name()='svg']")
    public WebElement topicDropdownArrowButton;

    @FindBy(xpath = "//*[contains(text(), 'Careers (HR)')]")
    public WebElement dropdownCareersOption;

    @FindBy(xpath = "//input[@name='company']")
    public WebElement companyInput;

    @FindBy(xpath = "//input[@name='subject']")
    public WebElement subjectInput;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement messageInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//form[@action='submit/']//*[local-name()='div' and contains(text(), 'This field is required')]")
    public WebElement emailErrorMessage;



}
