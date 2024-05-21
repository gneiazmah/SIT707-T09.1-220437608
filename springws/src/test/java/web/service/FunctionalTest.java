package web.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginAndNavigateThroughQuestions() {
        try {
            driver.get("http://localhost:8081/login");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Source: " + driver.getPageSource());

            // Login
            WebElement username = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("passwd"));
            WebElement dob = driver.findElement(By.name("dob"));
            WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
            username.sendKeys("ahsan");
            password.sendKeys("ahsan_pass");
            dob.sendKeys("2000-01-01");
            loginButton.click();

            // Wait for login result
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("/q1"),
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-message"))
            ));

            System.out.println("Current URL after login attempt: " + driver.getCurrentUrl());
            System.out.println("Page Source after login attempt: " + driver.getPageSource());

            // Check if login failed
            if (driver.getCurrentUrl().contains("/login")) {
                WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
                System.out.println("Login failed with error: " + errorMessage.getText());
                Assert.fail("Login failed with error: " + errorMessage.getText());
            }

            // Check Q1
            WebElement number1 = driver.findElement(By.name("number1"));
            WebElement number2 = driver.findElement(By.name("number2"));
            WebElement result = driver.findElement(By.name("result"));
            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            number1.sendKeys("1");
            number2.sendKeys("2");
            result.sendKeys("3");
            submitButton.click();

            // Wait for Q2 page to load
            wait.until(ExpectedConditions.urlContains("/q2"));
            System.out.println("Current URL after Q1: " + driver.getCurrentUrl());

            // Check Q2
            number1 = driver.findElement(By.name("number1"));
            number2 = driver.findElement(By.name("number2"));
            result = driver.findElement(By.name("result"));
            number1.sendKeys("5");
            number2.sendKeys("3");
            result.sendKeys("2");
            submitButton.click();

            // Wait for Q3 page to load
            wait.until(ExpectedConditions.urlContains("/q3"));
            System.out.println("Current URL after Q2: " + driver.getCurrentUrl());

            // Check Q3
            number1 = driver.findElement(By.name("number1"));
            number2 = driver.findElement(By.name("number2"));
            result = driver.findElement(By.name("result"));
            number1.sendKeys("3");
            number2.sendKeys("4");
            result.sendKeys("12");
            submitButton.click();

            // Wait for final page to load
            wait.until(ExpectedConditions.urlContains("/final"));
            System.out.println("Current URL after Q3: " + driver.getCurrentUrl());

            // Validate successful navigation to final page or result page
            WebElement finalMessage = driver.findElement(By.id("finalMessage"));
            Assert.assertEquals("Congratulations! You have completed the quiz.", finalMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
