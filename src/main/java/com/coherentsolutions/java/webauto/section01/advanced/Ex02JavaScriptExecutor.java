package com.coherentsolutions.java.webauto.section01.advanced;

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
 * Ex02JavaScriptExecutor demonstrates the usage of JavaScriptExecutor.
 */
public class Ex02JavaScriptExecutor {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    @Test
    public void testJavaScriptExecution() {
        driver.get("https://example.com");

        // Executing JavaScript
        ((JavascriptExecutor) driver).executeScript("alert('Hello, World!');");

        // Accepting alert
        driver.switchTo().alert().accept();

        // Fetching title using JavaScript
        String title = (String) ((JavascriptExecutor) driver).executeScript("return document.title;");
        Assert.assertEquals(title, "Example Domain", "Title does not match!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}