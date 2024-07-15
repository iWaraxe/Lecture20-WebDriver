package com.coherentsolutions.java.webauto.section02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Ex05CloseBrowser demonstrates how to close the browser using WebDriver.
 */
public class Ex05CloseBrowser {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to demonstrate closing the browser.
     */
    @Test
    public void testCloseBrowser() {
        driver.get("http://example.com");
        // Close the browser at the end of the test
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}