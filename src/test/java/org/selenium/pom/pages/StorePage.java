package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchField = By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCart = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    //Structural Page Object
    public StorePage textInputSearch(String searchText) {
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(searchText);
//        driver.findElement(searchField).sendKeys(searchText);
        return this;
    }

    public boolean isLoaded() {
        return waitLong.until(ExpectedConditions.urlContains("/store"));
    }

    //Functional
    public StorePage search(String searchText) {
        return textInputSearch(searchText).btnSearch();

    }

    public StorePage btnSearch(){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();

        return this;
    }

    public String getTitleSearch(){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public StorePage btnAddToCart(String productName){
        By addToCart = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCart).click();

        return this;
    }

    public CartPage btnViewCart() {
        driver.findElement(viewCart).click();

        return new CartPage(driver);
    }
}
