package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Ex03LocatorUsage demonstrates the usage of different locators.
 */
public class Ex03LocatorUsage {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    @Test
    public void testLocators() {
        driver.get("https://example.com");

        // Using tag name locator to find the div element
        WebElement elementByTag = driver.findElement(By.tagName("div"));
        Assert.assertTrue(elementByTag.isDisplayed(), "Div element is not displayed!");

        // Using CSS selector to find the link within the div
        WebElement elementByCss = driver.findElement(By.cssSelector("div > p > a"));
        Assert.assertTrue(elementByCss.isDisplayed(), "Link within the div is not displayed!");

        // Using XPath to find the link by its text
        WebElement elementByXpath = driver.findElement(By.xpath("//a[text()='More information...']"));
        elementByXpath.click();
        String expectedUrl = "https://www.iana.org/domains/example";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL does not match after click!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}