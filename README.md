# NopCommerce E2E Automation Framework

This project is an End-to-End (E2E) automation testing framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **ExtentReports**. It automates critical business flows of the [NopCommerce Demo](https://demo.nopcommerce.com/) website.

## 🚀 Key Features

-   **Page Object Model (POM)**: Separation of page objects and test logic for maintainability.
-   **Hybrid Framework**: Combines TestNG for execution and ExtentReports for reporting.
-   **Cross-Browser Support**: Configurable via `testng.xml` (Chrome, Edge, Firefox).
-   **Reporting**: Generates beautiful HTML reports with pass/fail status and logs.
-   **Utils**: Singleton `ExtentManager` for report generation.

## 🧪 Scenarios Implemented

1.  **User Registration**:
    -   Validates successful registration with dynamic email generation.
2.  **Login & Authentication**:
    -   Validates valid and invalid login attempts.
3.  **End-to-End Purchase Flow**:
    -   Search Product -> Add to Cart -> Checkout -> Payment -> Order Confirmation.
4.  **My Account Management**:
    -   Address Book CRUD operations (Add new address).

## 📂 Project Structure

```plaintext
E2E_Testing/
├── src/test/java/
│   └── com/e2e/
│       ├── pages/            # Page Object Classes (LoginPage, CheckoutPage, etc.)
│       ├── tests/            # Test Classes (NopCommerceTest, BaseTest)
│       └── utils/            # Utilities (ExtentManager)
├── testng.xml                # Test Runner Configuration
├── pom.xml                   # Maven Dependencies
└── target/extent-reports/    # Generated HTML Reports
```

## 🛠️ Prerequisites

-   **Java JDK 8+**
-   **Maven**
-   **Eclipse/IntelliJ IDE**

## 🏃 How to Run Tests

### Option 1: Using Eclipse/IDE
1.  Right-click on `testng.xml` in the project root.
2.  Select **Run As > TestNG Suite**.

### Option 2: Using Maven (Command Line)
```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

## 📊 Test Reports
After execution, the HTML report is generated at:
`target/extent-reports/extent-report.html`
