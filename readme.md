
# Cboe Contact Us Form Automation Framework

## Project Overview

This automation framework demonstrates a robust approach to testing the Contact Us form on the Cboe website (https://www.cboe.com/). It showcases best practices in test automation, including the use of Selenium WebDriver with Java, Cucumber for Behavior-Driven Development (BDD), and various design patterns and utilities for efficient and maintainable test code.

## Key Features

1. **Page Object Model (POM)**: Implements the POM design pattern for better maintainability and reusability of page-specific code.
2. **BDD with Cucumber**: Utilizes Gherkin syntax for writing clear, business-readable test scenarios.
3. **Selenium WebDriver**: Leverages Selenium for browser automation and interaction with web elements.
4. **Dynamic Element Handling**: Demonstrates techniques for interacting with dynamic elements such as dropdowns.
5. **Wait Strategies**: Implements explicit and implicit waits for improved test reliability.
6. **Fake Data Generation**: Uses JavaFaker to generate realistic test data for form submissions.
7. **Parallel Execution**: Configured to run tests in parallel for faster execution times.
8. **Logging**: Integrates SLF4J for comprehensive logging throughout the test execution.
9. **Reporting**: Generates detailed Cucumber reports for easy analysis of test results.

## Project Structure

```
├── src
│   └── test
│       ├── java
│       │   └── com
│       │       └── cboe
│       │           ├── pages
│       │           ├── runners
│       │           ├── steps
│       │           └── utils
│       └── resources
│           └── features
├── configuration.properties
├── pom.xml
└── README.md
```

- `src/test/java/com/cboe/pages`: Contains Page Object classes
- `src/test/java/com/cboe/runners`: Houses the test runner class
- `src/test/java/com/cboe/steps`: Includes step definition classes
- `src/test/java/com/cboe/utils`: Contains utility classes and helpers
- `src/test/resources/features`: Stores Cucumber feature files
- `configuration.properties`: Manages configuration settings
- `pom.xml`: Maven project object model file

## Technologies Used

- Java 8+
- Selenium WebDriver
- Cucumber
- JUnit
- Maven
- SLF4J
- JavaFaker

## Getting Started

1. Clone the repository:

```git clone https://github.com/kpuiiuiii/CboeFramework```

2. Navigate to the project directory:

```cd CboeFramework```



3. Run the tests using Maven:

   ```mvn clean test```


## Test Execution

- Tests are configured to run in parallel using Maven Surefire Plugin.
- The `parallel` setting in `pom.xml` allows for concurrent execution of scenarios.
- Test results and logs can be found in the `target` directory after execution.

## Reporting

Cucumber generates comprehensive reports that can be found in the `target` directory after test execution. These reports provide detailed information about test scenarios, steps, and their execution status.

## Best Practices Demonstrated

1. **Separation of Concerns**: Clear separation between page objects, step definitions, and test runners.
2. **Configuration Management**: Externalized configuration using `configuration.properties`.
3. **Reusable Components**: Utility classes for common operations and data generation.
4. **Scalability**: Framework designed to easily accommodate additional test scenarios and page objects.
5. **Maintainability**: Use of Page Object Model and BDD patterns for easier maintenance and readability.

## Potential Enhancements

1. Integration with CI/CD pipelines (e.g., Jenkins, GitLab CI)
2. Implementation of API tests for backend validation
3. Integration with test management tools
4. Addition of visual regression testing
5. Implementation of accessibility testing
