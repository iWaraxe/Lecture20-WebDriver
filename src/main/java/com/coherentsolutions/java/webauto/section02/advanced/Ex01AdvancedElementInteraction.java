package com.coherentsolutions.java.webauto.section02.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Ex01AdvancedElementInteraction demonstrates advanced interactions with web elements.
 */
public class Ex01AdvancedElementInteraction {
    private WebDriver driver;

    /**
     * Setup method to initialize the WebDriver instance.
     */
    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    /**
     * Test method to demonstrate advanced element interactions.
     */
    @Test
    public void testAdvancedElementInteraction() {
        driver.get("http://coherentsolutions.com/");

        // Find and click the "Schedule a consultation" button
        WebElement scheduleConsultationButton = driver.findElement(By.cssSelector(".cta-button"));
        scheduleConsultationButton.click();

        // Add a wait to ensure the element is interactable
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cleanup method to close the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}