package com.genesys.framework.selenium.pom;

import com.genesys.framework.config.SauceDemoConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class SauceDemoInventoryPage extends BasePage {
    private final SauceDemoConfig sauceDemoConfig;

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpackButton;
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartFleeceJacketButton;
    @FindBy(how = How.XPATH, using = "//span[@data-test='shopping-cart-badge']")
    private WebElement shoppingCartBadge;
    protected SauceDemoInventoryPage(final WebDriverFactory driverFactory, final SauceDemoConfig sauceDemoConfig) {
        super(driverFactory);
        this.sauceDemoConfig = sauceDemoConfig;
    }

    @Override
    protected boolean isAt() {
        return addToCartBackpackButton.isDisplayed();
    }

    @Override
    public void open() {
        driverFactory.getDriver().get(sauceDemoConfig.getUrl() + "/inventory.html");
    }

    public SauceDemoInventoryPage selectItem(final String item) {
        switch (item) {
            case "Sauce Labs Backpack" -> addToCartBackpackButton.click();
            case "Sauce Labs Fleece Jacket" -> addToCartFleeceJacketButton.click();
            default -> {
                throw new RuntimeException(item + " is not an option!");
            }
        }
        return this;
    }

    public String getNumberOnCartIcon(){
        return shoppingCartBadge.getText();
    }
}
