package com.e2e.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    public static com.aventstack.extentreports.ExtentReports extent;
    public static com.aventstack.extentreports.ExtentTest test;

    @org.testng.annotations.BeforeSuite
    public void beforeSuite() {
        com.e2e.utils.ExtentManager.getInstance();
    }

    @org.testng.annotations.AfterSuite
    public void afterSuite() {
        if (com.e2e.utils.ExtentManager.getInstance() != null) {
            com.e2e.utils.ExtentManager.getInstance().flush();
        }
    }

    @BeforeMethod
    @org.testng.annotations.Parameters("browser")
    public void setUp(@org.testng.annotations.Optional("chrome") String browser, java.lang.reflect.Method method) {
        test = com.e2e.utils.ExtentManager.getInstance().createTest(method.getName());

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new org.openqa.selenium.edge.EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new org.openqa.selenium.firefox.FirefoxDriver();
        } else {
            // Default to chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(org.testng.ITestResult result) {
        if (result.getStatus() == org.testng.ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            // Optional: Add screenshot capture here
        } else if (result.getStatus() == org.testng.ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else {
            test.skip("Test skipped");
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
