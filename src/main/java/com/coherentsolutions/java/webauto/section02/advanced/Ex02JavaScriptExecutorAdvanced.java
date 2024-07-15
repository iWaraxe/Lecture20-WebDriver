package com.coherentsolutions.java.webauto.section02.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Ex02JavaScriptExecutorAdvanced demonstrates advanced usage of JavaScriptExecutor.
 */
public class Ex02JavaScriptExecutorAdvanced {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to demonstrate advanced JavaScript execution.
     */
    @Test
    public void testJavaScriptExecution() {
        driver.get("http://coherentsolutions.com/");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Execute JavaScript to get the title
        String title = (String) jsExecutor.executeScript("return document.title;");
        Assert.assertEquals(title, "Custom Software Development & Engineering Company | Coherent Solutions", "Title does not match!");

        // Execute JavaScript to click the "Schedule a consultation" button
        WebElement element = driver.findElement(By.cssSelector(".cta-button"));
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}