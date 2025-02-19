@Max
Feature: Cboe Quotes - Options Chain Data Verification

  Scenario: Verifying Options Chain Data for SPX
    Given market analyst "Alex" is on the Cboe homepage
    When navigates to the "Delayed Quotes" section
    And enters the symbol "SPX" for the S&P 500 Index
    Then the options chain tables should be displayed
    And the table should include columns for "Calls" and "Puts"
    And the strike prices should be listed in ascending order
    And bid and ask prices should be visible for each option
    And the options chain table should contain data rows