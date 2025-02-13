package com.genesys.framework.selenium.pom.sauceDemo;

import com.genesys.framework.config.SauceDemoConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class SauceDemoCheckoutStepTwoPage extends BasePage {
    private final SauceDemoConfig sauceDemoConfig;

    @FindBy(how = How.ID, using = "finish")
    private WebElement finishButton;

    protected SauceDemoCheckoutStepTwoPage(final WebDriverFactory driverFactory, final SauceDemoConfig sauceDemoConfig) {
        super(driverFactory);
        this.sauceDemoConfig = sauceDemoConfig;
    }

    @Override
    public boolean isAt() {
        return finishButton.isDisplayed();
    }

    public SauceDemoCheckoutStepTwoPage clickFinishButton() {
        finishButton.click();

        return this;
    }
}
