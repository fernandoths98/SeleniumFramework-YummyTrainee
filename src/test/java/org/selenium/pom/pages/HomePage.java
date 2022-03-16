package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    private final By storeNavLink = By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StorePage clickStoreNavLink() {
        driver.findElement(storeNavLink).click();

        return new StorePage(driver);
    }

    public HomePage API(){
        API("/");
        return this;
    }
}
