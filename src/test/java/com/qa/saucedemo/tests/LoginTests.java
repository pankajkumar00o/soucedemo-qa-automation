package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.pages.InventoryPage;
import com.qa.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(description = "A valid user can sign in and reach the product inventory")
    public void validUserCanLogin() {
        LoginPage login = new LoginPage(driver).open(baseUrl());
        login.loginAs("standard_user", "secret_sauce");

        Assert.assertEquals(new InventoryPage(driver).heading(), "Products");
    }

    @Test(description = "A locked-out user sees the expected validation message")
    public void lockedOutUserSeesError() {
        LoginPage login = new LoginPage(driver).open(baseUrl());
        login.loginAs("locked_out_user", "secret_sauce");

        Assert.assertTrue(login.errorText().contains("Sorry, this user has been locked out"));
    }
}
