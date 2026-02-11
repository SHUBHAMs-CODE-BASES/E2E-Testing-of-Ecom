# E2E Testing Framework

This project is an End-to-End (E2E) automation testing framework built using **Java**, **Selenium WebDriver**, and **TestNG**. It is designed to automate web application testing, specifically demonstrating a test case for the Technocrats Group website.

## 🚀 Features

-   **Selenium WebDriver**: For browser automation.
-   **TestNG**: For test configuration, annotations (`@Test`, `@BeforeMethod`, `@AfterMethod`), and assertions.
-   **WebDriverManager**: Automated management of browser drivers (e.g., ChromeDriver), eliminating the need to manually download and set path for drivers.
-   **Maven**: Dependency management and build lifecycle.
-   **Modular Design**: Separation of test setup (`BaseTest`) and test execution (`TechnocratsTest`).

## 🛠️ Prerequisites

Before you begin, ensure you have the following installed on your machine:

-   **Java Development Kit (JDK)**: Version 8 or higher.
-   **Apache Maven**: For building the project and running tests.
-   **IDE**: Eclipse, IntelliJ IDEA, or VS Code (with Java extensions).
-   **Google Chrome**: The browser used for the current test configuration.

## 📂 Project Structure

```plaintext
E2E_Testing/
├── src/test/java/            # Test source code
│   └── com/e2e/tests/
│       ├── BaseTest.java     # Base class for initializing and tearing down the driver
│       └── TechnocratsTest.java # Test class containing actual test cases
├── pom.xml                   # Maven configuration and dependencies
├── .project                  # Eclipse project configuration
├── .classpath                # Eclipse classpath configuration
└── target/                   # Compiled build artifacts and test results
```

## 📦 Dependencies

The project uses the following key dependencies (defined in `pom.xml`):

| Dependency | Version | Purpose |
| :--- | :--- | :--- |
| **Selenium Java** | 4.18.1 | Core library for browser automation. |
| **TestNG** | 7.9.0 | Testing framework for running tests and assertions. |
| **WebDriverManager** | 5.7.0 | Manages browser driver binaries automatically. |

## ⚙️ Setup & Installation

1.  **Clone the repository** (or download usage):
    ```bash
    git clone <repository-url>
    ```
2.  **Navigate to the project directory**:
    ```bash
    cd E2E_Testing
    ```
3.  **Install dependencies**:
    ```bash
    mvn clean install
    ```

## 🏃2; How to Run Tests

### Using Command Line (Maven)
To run the tests using Maven, executes:
```bash
mvn test
```

### Using IDE (Eclipse/IntelliJ)
1.  Navigate to `src/test/java/com/e2e/tests/TechnocratsTest.java`.
2.  Right-click on the file.
3.  Select **Run As** > **TestNG Test**.

## 📝 Code Overview

### `BaseTest.java`
This class handles the lifecycle of the WebDriver.
-   `@BeforeMethod`: Runs before each test method. It sets up the ChromeDriver using WebDriverManager and initializes the browser instance.
-   `@AfterMethod`: Runs after each test method. It quits the driver to close the browser window and clear resources.

### `TechnocratsTest.java`
This class extends `BaseTest` and contains the test scenarios.
-   `testWebsiteTitle()`: Navigates to `https://technocratsgroup.edu.in/`, retrieves the page title, and asserts that it contains the word "Technocrats".
