package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));
    }

    public String heading() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public String firstItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".cart_item .inventory_item_name"))).getText();
    }
}
