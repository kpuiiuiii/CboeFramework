package com.project.pages;

import com.project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {


    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='phone_number']")
    private WebElement phoneNameInput;

    @FindBy(xpath = "//form[@action='submit/']//*[local-name()='svg']")
    private WebElement topicDropdownArrowButton;

    @FindBy(xpath = "//*[contains(text(), 'Careers (HR)')]")
    private WebElement dropdownCareersOption;

    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyInput;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectInput;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement messageInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//form[@action='submit/']//*[local-name()='div' and contains(text(), 'This field is required')]")
    private WebElement emailErrorMessage;

    // --- Getters for WebElements ---
    // It is a good practice create methods to get the WebElements

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPhoneNameInput() {
        return phoneNameInput;
    }

    public WebElement getTopicDropdownArrowButton() {
        return topicDropdownArrowButton;
    }

    public WebElement getDropdownCareersOption() {
        return dropdownCareersOption;
    }

    public WebElement getCompanyInput() {
        return companyInput;
    }

    public WebElement getSubjectInput() {
        return subjectInput;
    }

    public WebElement getMessageInput() {
        return messageInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }


}
