package com.project.pages;

import com.project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {


    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    public  WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneNameInput;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement messageInput;


    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//label[contains(text(),'Email must be formatted correctly.')]")
    public WebElement emailErrorMessage;



}
