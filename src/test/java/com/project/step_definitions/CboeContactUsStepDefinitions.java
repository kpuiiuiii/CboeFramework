package com.project.step_definitions;

import com.github.javafaker.Faker;
import com.project.pages.ContactUsPage;
import com.project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CboeContactUsStepDefinitions {

    ContactUsPage contactUsPage;
    Actions actions;
    Wait wait;

    @Given("I am on the Cboe Contact Us page")
    public void i_am_on_the_cboe_contact_us_page() {
        Driver.getDriver().get("https://www.cboe.com/contact/");
        contactUsPage = new ContactUsPage();

        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.cookiesAcceptButton));

        contactUsPage.cookiesAcceptButton.click();


    }

    @When("I fill in the contact form with valid information")
    public void i_fill_in_the_contact_form_with_valid_information() {
        Faker faker = new Faker();
        actions = new Actions(Driver.getDriver());
        contactUsPage = new ContactUsPage();

        contactUsPage.firstNameInput.sendKeys(faker.name().firstName());
        contactUsPage.lastNameInput.sendKeys(faker.name().lastName());
        contactUsPage.emailInput.sendKeys(faker.internet().emailAddress());
        contactUsPage.phoneNameInput.sendKeys(faker.phoneNumber().phoneNumber());
        contactUsPage.topicDropdownArrowButton.click();
        contactUsPage.dropdownCareersOption.click();
        contactUsPage.messageInput.sendKeys(faker.lorem().sentence(5));


    }

    @When("I click the {string} button")
    public void i_click_the_button(String string) {
        contactUsPage = new ContactUsPage();
        contactUsPage.submitButton.click();


    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        contactUsPage = new ContactUsPage();
        Assert.assertEquals("This field is required", contactUsPage.emailErrorMessage.getText());

    }

}
