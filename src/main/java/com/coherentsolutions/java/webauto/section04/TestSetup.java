package com.coherentsolutions.java.webauto.section04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSetup {
    public static void main(String[] args) {
        // Настройка Chromedriver
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        // Настройка Geckodriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();

        // Пример запуска браузеров
        chromeDriver.get("https://example.com");
        firefoxDriver.get("https://example.com");

        // Закрытие браузеров
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}