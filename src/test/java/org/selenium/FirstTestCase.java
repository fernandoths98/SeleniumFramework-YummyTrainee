package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class FirstTestCase extends BaseTest {

    @Test
    public void dummyTest() throws InterruptedException, IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        StorePage storePage = new HomePage(driver).
                API()
                .clickStoreNavLink();
//        Thread.sleep(2000);
        storePage.isLoaded();
        storePage.search(searchFor);
        //Functipnal
        //Structural Page Object
//        storePage.
//                textInputSearch("Blue")
//                .btnSearch();
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitleSearch(), "Search results: “" +searchFor+"”");
        storePage.btnAddToCart(product.getName());
//        Thread.sleep(2000);
        CartPage cartPage =  storePage.btnViewCart();
        cartPage.isLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.btnCheckout()
                .setBillingAddress(billingAddress)
                .btnPlaceOrder();
//        Thread.sleep(2000);
//        Assert.assertEquals(checkoutPage.getNotice(), "");
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

        driver.quit();
    }

    @Test
    public void dummyTestLoginandCheckout() throws InterruptedException, IOException {

//        driver.get("https://askomdch.com/");
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        User user = new User("logintest","123456");

        StorePage storePage = new HomePage(driver).
                API()
                .clickStoreNavLink();
//        Thread.sleep(2000);
        storePage.isLoaded();
        storePage.search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitleSearch(), "Search results: “"+searchFor+"”");

        storePage.btnAddToCart("Blue Shoes");
        Thread.sleep(2000);

        CartPage cartPage = storePage.btnViewCart();
        cartPage.isLoaded();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.btnCheckout();
        checkoutPage.btnLogin();
        Thread.sleep(2000);

        checkoutPage.
                login("logintest","123456")
                .setBillingAddress(billingAddress)
                .btnPlaceOrder();
        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

//
//        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
//        driver.findElement(By.cssSelector(".showlogin")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.id("username")).sendKeys("logintest");
//        driver.findElement(By.id("password")).sendKeys("123456");
//        driver.findElement(By.name("login")).click();
//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_postcode")).clear();
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//        driver.findElement(By.id("billing_email")).clear();
//        driver.findElement(By.id("billing_email")).sendKeys("testuser@gmail.com");
//        driver.findElement(By.id("place_order")).click();
//        Thread.sleep(2000);
//        Assert.assertEquals(driver.findElement(
//                        By.cssSelector(".woocommerce-notice")).getText(),
//                "Thank you. Your order has been received."
//        );

        driver.quit();
    }
}
