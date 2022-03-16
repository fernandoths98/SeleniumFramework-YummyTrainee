package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {

    private final By btnLoginCheckout = By.className("showlogin");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.name("login");
    private final By firstNameEt = By.id("billing_first_name");
    private final By lastNameEt = By.id("billing_last_name");
    private final By addressEt = By.id("billing_address_1");
    private final By cityEt = By.id("billing_city");
    private final By postCodeEt = By.id("billing_postcode");
    private final By emailEt = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
//    private final By successNotice = By.className(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage btnLogin(){
        driver.findElement(btnLoginCheckout).click();
        return this;
    }

    public CheckoutPage enterFirstName(String firstName) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(firstNameEt));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(lastNameEt));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddress(String address) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(addressEt));
        e.clear();
        e.sendKeys(address);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(cityEt));
        e.clear();
        e.sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostCode(String postCode) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(postCodeEt));
        e.clear();
        e.sendKeys(postCode);
        return this;
    }

    public CheckoutPage enterEmail(String email) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(emailEt));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .enterAddress(billingAddress.getAddressLineOne())
                .enterCity(billingAddress.getCity())
                .enterPostCode(billingAddress.getPostalCode())
                .enterEmail(billingAddress.getEmail());
    }

    public CheckoutPage btnPlaceOrder(){
        waitForOverlayToDisapper(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }

    public CheckoutPage enterUsername(String username) {
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        return this;
    }

    public CheckoutPage enterPassword(String password) {
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginBtn(){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        return this;
    }

    public CheckoutPage login (String username, String password){
        return enterUsername(username).enterPassword(password).clickLoginBtn();
    }

    public CheckoutPage loginUser(){
        return this;
    }
}
