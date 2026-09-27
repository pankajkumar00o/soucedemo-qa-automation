package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By heading = By.cssSelector(".title");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");
    private final By sortDropdown = By.className("product_sort_container");
    private final By firstProductName = By.cssSelector(".inventory_item_name");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(heading));
    }

    public String heading() {
        return driver.findElement(heading).getText();
    }

    public void addProductToCart(String productSlug) {
        By addButton = By.id("add-to-cart-" + productSlug);
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public String cartCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }

    public void sortByPriceLowToHigh() {
        new Select(driver.findElement(sortDropdown)).selectByValue("lohi");
    }

    public String firstProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductName)).getText();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
}
