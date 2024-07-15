package com.coherentsolutions.java.webauto.section04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {
    // Homework #20 task
    @Test
    public void simpleTest() {
        WebDriver driver = new SafariDriver();
        driver.get("https://yandex.com/");
        By elementLocator = By.cssSelector(".headline__personal-enter");
        WebElement element = driver.findElement(elementLocator);
        String text = element.getText();
        Assert.assertEquals(text, "Log in");
        driver.close();
    }
}
