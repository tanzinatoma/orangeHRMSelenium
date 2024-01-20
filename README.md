# OrangeHRM Selenium Automation

This repository contains a suite of automated test scripts for the OrangeHRM application, implemented using Selenium WebDriver and TestNG.

## Project Structure

```css
orangeHRMSelenium/
├── drivers/
│   └── chromedriver
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── resources/
│   │           ├── Base.java
│   │           └── TestData.properties
│   │
│   └── test/
│       ├── java/
│       │   └── pages/
│       │       ├── admin
│       │       │   ├── AddUserPage.java
│       │       │   └── UserListPage.java
│       │       └── LoginPage.java
│       │
│       └── tests/
│           ├── admin
│           │   ├── AddUserTests.java
│           │   └── UserEditDeleteTests.java
│           └── LoginPage.java
│
├── pom.xml
│
└── README.md
```
## Page Objects and Page Component Objects
The project uses Page Objects and Page Component Objects to capture the relevant behaviors of a web page. Thus, in the test directory classes are divided between pages and tests.

- **`src/main/resources`**: Houses resources for testing, such as test-specific configuration files and test data.
- **`src/main/test/java`**: Contains test code for main resources.
- **`src/main/test/java/pages`**: Contains Java classes representing web pages. Each class may include elements and action methods related to a specific page.
- **`src/main/test/java/tests`**: Contains Java classes representing automated test scenarios. Each test class utilizes elements and action methods from the corresponding `pages` to perform different flows.
## Packages Used

- **Selenium**: Used for automating web application testing across various browsers.
- **TestNG**: Testing framework used for writing and running tests.
- **JUnit**: Another option for writing and executing test cases.



