package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Ex01SafariWebDriverSetup demonstrates the basic setup of WebDriver for Safari.
 */
public class Ex01SafariWebDriverSetup {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to open a website and verify the title.
     */
    @Test
    public void testOpenWebsite() {
        driver.get("https://example.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Example Domain", "Title does not match!");
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}