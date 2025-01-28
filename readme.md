

# Cboe Contact Us Form Automation Demo

## Project Overview

This project is a demonstration of automated testing for the Cboe Contact Us form. It's designed to showcase test automation skills using Selenium WebDriver with Java, Cucumber for BDD, and other best practices in test automation.

## Technologies Used

- Java 21
- Selenium WebDriver
- Cucumber for BDD
- JUnit for test assertions
- Maven for project management and dependencies
- JavaFaker for generating test data

## Project Structure

The project follows a standard Maven structure:

```
src
├── main
│   └── java
│       └── com
│           └── project
│               ├── pages
│               └── utilities
└── test
├── java
│   └── com
│       └── project
│           └── step_definitions
└── resources
└── features
```

## Key Features

1. Page Object Model (POM) design pattern
2. BDD scenarios written in Gherkin syntax
3. Automated form filling and submission
4. Handling of dynamic elements like dropdowns
5. Waits for better synchronization
6. Fake data generation for realistic test scenarios

## Running the Tests

To run the tests, use the following Maven command:

```
mvn clean test
```

## Reporting

After test execution, you can find the Cucumber reports in the `target` directory.

## Notes for Interviewers

- This project demonstrates proficiency in setting up a test automation framework from scratch.
- It showcases the ability to work with modern testing tools and practices.
- The code includes examples of handling common web elements and scenarios.
- Best practices such as explicit waits and the Page Object Model are implemented.

Feel free to explore the code and ask any questions about the implementation or design decisions!



