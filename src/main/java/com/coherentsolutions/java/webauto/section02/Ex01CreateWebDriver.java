package com.coherentsolutions.java.webauto.section02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Ex01CreateWebDriver demonstrates how to create a WebDriver instance.
 */
public class Ex01CreateWebDriver {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to demonstrate WebDriver instance creation.
     */
    @Test
    public void testCreateWebDriver() {
        // WebDriver instance is already created in setUp method
        Assert.assertNotNull(driver, "Driver should be initialized.");
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
