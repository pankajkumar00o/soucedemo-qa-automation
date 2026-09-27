package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.pages.InventoryPage;
import com.qa.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSortTests extends BaseTest {
    @Test(description = "Price low-to-high puts the least expensive product first")
    public void sortProductsByPriceLowToHigh() {
        new LoginPage(driver).open(baseUrl()).loginAs("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.sortByPriceLowToHigh();

        Assert.assertEquals(inventory.firstProductName(), "Sauce Labs Onesie");
    }
}
