package com.coherentsolutions.java.webauto.section03.advanced;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

/**
 * Ex02JavaScriptExecutorSetup demonstrates the usage of JavaScriptExecutor.
 */
public class Ex02JavaScriptExecutorSetup {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.safari.driver", "/path/to/safaridriver");
        driver = new SafariDriver();
        driver.get("https://coherentsolutions.com");
    }

    /**
     * Test method to demonstrate executing JavaScript in the browser context.
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
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * Main method to run the test from command line.
     */
    public static void main(String[] args) {
        Ex02JavaScriptExecutorSetup test = new Ex02JavaScriptExecutorSetup();
        test.openBrowser();
        test.testJavaScriptExecution();
        test.closeBrowser();
    }
}