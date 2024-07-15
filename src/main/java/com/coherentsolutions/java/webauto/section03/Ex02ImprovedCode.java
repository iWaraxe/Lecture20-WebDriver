package com.coherentsolutions.java.webauto.section03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Ex02ImprovedCode demonstrates the improved setup and execution of a Selenium test with TestNG annotations.
 */
public class Ex02ImprovedCode {
    private WebDriver driver;
    private static final By SEARCH_BUTTON = By.cssSelector(".mini-suggest__button");

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Simple test to verify basic Selenium setup.
     */
    @Test
    public void simpleTest() {
        driver.get("https://yandex.com/");

        // Wait for the page to load fully
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        // Check if the element is present
        if (driver.findElements(SEARCH_BUTTON).size() == 0) {
            System.out.println("Element with CSS selector '.mini-suggest__button' is not present on the page.");
            Assert.fail("Element with CSS selector '.mini-suggest__button' is not present on the page.");
        }

        WebElement element = driver.findElement(SEARCH_BUTTON);
        String textOfElement = element.getText();
        System.out.println(textOfElement);
        Assert.assertEquals(textOfElement, "Search", "Actual text of the element doesn't match expected");
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /**
     * Main method to run the test from command line.
     */
    public static void main(String[] args) {
        Ex02ImprovedCode test = new Ex02ImprovedCode();
        test.setUp();
        test.simpleTest();
        test.tearDown();
    }
}