package com.qa.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;

public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        Path chromium = Path.of("/usr/bin/chromium");
        if (Files.isExecutable(chromium)) {
            options.setBinary(chromium.toString());
        }
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--window-size=1440,1000");
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options); // Selenium Manager resolves the matching driver.
    }
}
