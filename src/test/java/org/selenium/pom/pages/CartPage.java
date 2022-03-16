package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn = By.cssSelector(".checkout-button");
    private final By cartHeading = By.cssSelector(".has-text-align-center");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return waitLong.until(ExpectedConditions.textToBe(cartHeading, "Cart"));
    }

    public String getProductName(){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public CheckoutPage btnCheckout() {
        waitLong.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        return new CheckoutPage(driver);
    }
}
