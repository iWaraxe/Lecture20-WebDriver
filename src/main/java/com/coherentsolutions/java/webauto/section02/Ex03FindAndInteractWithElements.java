package com.coherentsolutions.java.webauto.section02;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/**
 * Ex03FindAndInteractWithElements demonstrates how to find and interact with web elements on the Coherent Solutions homepage.
 */
public class Ex03FindAndInteractWithElements {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to verify the page title.
     */
    @Test
    public void testOpenAUT() {
        driver.get("http://coherentsolutions.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Custom Software Development & Engineering Company | Coherent Solutions", "Page title does not match!");
    }

    /**
     * Test method to verify the main header elements.
     */
    @Test
    public void testHeaderElements() {
        driver.get("http://coherentsolutions.com/");

        // Verify the logo is present
        WebElement logo = driver.findElement(By.className("site-logo"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed!");

        // Verify the main navigation is present
        WebElement mainNavigation = driver.findElement(By.className("main-navigation"));
        Assert.assertTrue(mainNavigation.isDisplayed(), "Main navigation is not displayed!");

        // Verify main menu items
        List<WebElement> menuItems = mainNavigation.findElements(By.cssSelector(".main-menu-desktop .menu-item"));
        Assert.assertTrue(menuItems.size() > 0, "Main menu items are not present!");
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}