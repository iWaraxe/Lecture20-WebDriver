package com.coherentsolutions.java.webauto.section01.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Ex01AdvancedInteractions demonstrates advanced interactions using Actions class.
 */
public class Ex01AdvancedInteractions {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }


    @Test
    public void testAdvancedInteractions() {
        // Open the custom HTML file
        driver.get("file:///Users/igorwaraxe/JAVA/JAVA/QA Auto (Java Web Automation)/Lectures/Lecture20/Lecture20-WebDriver/src/main/resources/advanced_interactions_example.html");

        WebElement element = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(element, target).perform();

        // This is a simple example; update with appropriate checks based on the page behavior
        // For now, just verifying the positions have changed can be a basic check
        Assert.assertNotEquals(element.getLocation(), target.getLocation(), "Element was not dragged!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}