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
 * Ex04PerformAssertions demonstrates how to perform assertions on web elements.
 */
public class Ex04PerformAssertions {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to perform assertions.
     */
    @Test
    public void testPerformAssertions() {
        driver.get("http://coherentsolutions.com/");

        // Perform an assertion on the page title
        Assert.assertEquals(driver.getTitle(), "Custom Software Development & Engineering Company | Coherent Solutions", "Title does not match!");

        // Perform an assertion on an element with ID "menuToggleBtn"
        WebElement menuToggleButton = driver.findElement(By.id("menuToggleBtn"));
        Assert.assertTrue(menuToggleButton.isDisplayed(), "Menu toggle button is not displayed!");

        // Perform an assertion on the text of the element if needed
        // For example:
        // Assert.assertEquals(menuToggleButton.getText(), "Expected Text", "Text does not match!");
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}