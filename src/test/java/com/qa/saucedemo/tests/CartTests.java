package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.pages.CartPage;
import com.qa.saucedemo.pages.InventoryPage;
import com.qa.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @Test(description = "Adding a product updates the cart and displays the selected item")
    public void addProductToCart() {
        new LoginPage(driver).open(baseUrl()).loginAs("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addProductToCart("sauce-labs-backpack");

        Assert.assertEquals(inventory.cartCount(), "1");
        inventory.openCart();
        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.heading(), "Your Cart");
        Assert.assertEquals(cart.firstItemName(), "Sauce Labs Backpack");
    }
}
