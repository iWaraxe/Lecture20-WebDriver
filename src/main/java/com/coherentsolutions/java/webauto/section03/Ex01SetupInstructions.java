package com.coherentsolutions.java.webauto.section03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Ex01SetupInstructions demonstrates the basic setup and execution of a Selenium test.
 */
public class Ex01SetupInstructions {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        // Set the path for ChromeDriver if not added to PATH
        System.setProperty("webdriver.safari.driver", "/path/to/safaridriver");
        driver = new SafariDriver();
    }

    /**
     * Simple test to verify basic Selenium setup.
     */
    @Test
    public void simpleTest() {
        driver.get("https://yandex.com/");
        By elementLocator = By.cssSelector(".mini-suggest__button");
        WebElement element = driver.findElement(elementLocator);
        String textOfElement = element.getText();
        System.out.println(textOfElement);
        Assert.assertEquals(textOfElement, "Search", "Actual text of the element doesn't match expected");
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /**
     * Main method to run the test from command line.
     */
    public static void main(String[] args) {
        Ex01SetupInstructions test = new Ex01SetupInstructions();
        test.setUp();
        test.simpleTest();
        test.tearDown();
    }
}