package com.genesys.framework.selenium.pom;

import com.genesys.framework.config.SauceDemoConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class SauceDemoLoginPage extends BasePage {
    private final SauceDemoConfig sauceDemoConfig;
    @FindBy(how = How.ID, using = "user-name")
    private       WebElement      usernameInputField;
    @FindBy(how = How.ID, using = "password")
    private       WebElement   passwordInputField;
    @FindBy(how = How.ID, using = "login-button")
    private       WebElement   loginButton;

    protected SauceDemoLoginPage(final WebDriverFactory driverFactory, final SauceDemoConfig sauceDemoConfig) {
        super(driverFactory);
        this.sauceDemoConfig = sauceDemoConfig;
    }

    @Override
    protected boolean isAt() {
        return loginButton.isDisplayed();
    }

    public void open() {
        driverFactory.getDriver().get(sauceDemoConfig.getUrl());
    }

    public SauceDemoLoginPage login() {
        //TODO: CRED- JSON
        usernameInputField.sendKeys("performance_glitch_user");
        passwordInputField.sendKeys("secret_sauce");
        loginButton.click();

        return this;
    }
}
