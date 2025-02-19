
Feature: Contact Us Form Submission

  As a user seeking support,
  I want to be able to submit a request through the contact form on the Cboe support page,
  So that I can receive assistance with my issue.

  Scenario: Submit a support request
    Given I am on the Cboe Contact Us page
    When I fill in the contact form with valid information
    And I submit the contact form
    Then I should see an error message indicating "This field is required"