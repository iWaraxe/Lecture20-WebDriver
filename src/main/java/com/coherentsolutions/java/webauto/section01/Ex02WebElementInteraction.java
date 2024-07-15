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
 * Ex02WebElementInteraction demonstrates finding and interacting with web elements.
 */
public class Ex02WebElementInteraction {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
    }

    @Test
    public void testInteractWithElement() {
        driver.get("https://example.com");
        WebElement element = driver.findElement(By.cssSelector("a[href='https://www.iana.org/domains/example']"));
        element.click();
        String expectedUrl = "https://www.iana.org/domains/example";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL does not match after click!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}