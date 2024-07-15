package com.coherentsolutions.java.webauto.section02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Ex02OpenAUT demonstrates how to open the Application Under Test (AUT).
 */
public class Ex02OpenAUT {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to open the AUT.
     */
    @Test
    public void testOpenAUT() {
        driver.get("http://coherentsolutions.com/");
        // Verify the page title
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        // Add assertion to check the page title
        Assert.assertEquals(title, "Custom Software Development & Engineering Company | Coherent Solutions", "Page title does not match!");
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
