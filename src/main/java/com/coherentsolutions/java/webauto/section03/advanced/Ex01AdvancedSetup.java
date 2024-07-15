package com.coherentsolutions.java.webauto.section03.advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

/**
 * Ex01AdvancedSetup demonstrates advanced interactions using Actions class.
 */
public class Ex01AdvancedSetup {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.safari.driver", "/path/to/safaridriver");
        driver = new SafariDriver();
        driver.get("file:///Users/igorwaraxe/JAVA/JAVA/QA Auto (Java Web Automation)/Lectures/Lecture20/Lecture20-WebDriver/src/main/resources/advanced_interactions_example.html");
    }

    /**
     * Test method to demonstrate drag and drop interaction.
     */
    @Test
    public void testAdvancedInteractions() {
        WebElement element = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(element, target).perform();

        String droppedText = target.getText();
        Assert.assertEquals(droppedText, "Drop here", "Text after drop does not match!");
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
        Ex01AdvancedSetup test = new Ex01AdvancedSetup();
        test.openBrowser();
        test.testAdvancedInteractions();
        test.closeBrowser();
    }
}