package com.genesys.framework.selenium.pom.sauceDemo;

import com.genesys.framework.config.SauceDemoConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class SauceDemoInventoryPage extends BasePage {
    private final SauceDemoConfig sauceDemoConfig;

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpackButton;
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartFleeceJacketButton;
    @FindBy(how = How.XPATH, using = "//div[@data-test='footer-copy']")
    private WebElement footerMessageContainer;

    @FindBy(how = How.XPATH, using = "//span[@data-test='shopping-cart-badge']")
    private WebElement shoppingCartBadge;


    protected SauceDemoInventoryPage(final WebDriverFactory driverFactory, final SauceDemoConfig sauceDemoConfig) {
        super(driverFactory);
        this.sauceDemoConfig = sauceDemoConfig;
    }

    @Override
    public boolean isAt() {
        return addToCartBackpackButton.isDisplayed();
    }

    public void open() {
        driverFactory.getDriver().get(sauceDemoConfig.getUrl() + "/inventory.html");
    }

    public SauceDemoInventoryPage selectItem(final String item) {
        switch (item) {
            case "backpack" -> addToCartBackpackButton.click();
            case "jacket" -> addToCartFleeceJacketButton.click();
            default -> {
                throw new RuntimeException(item + " is not an option!");
            }
        }
        return this;
    }

    public int getNumberOnCartIcon() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public SauceDemoInventoryPage clickOnTheChartIcon() {
        shoppingCartBadge.click();

        return this;
    }

    public String getFooterMessage() {
        return footerMessageContainer.getText();
    }

    public SauceDemoInventoryPage scrollToFooter() {
        jsExcecutor.executeScript("arguments[0].scrollIntoView(true);", footerMessageContainer);

        return this;
    }
}
