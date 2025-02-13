package com.genesys.framework.selenium.pom.sauceDemo;

import com.genesys.framework.config.SauceDemoConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
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
    public boolean isAt() {
        return loginButton.isDisplayed();
    }

    public void open() {
        driverFactory.getDriver().get(sauceDemoConfig.getUrl());
    }

    public SauceDemoLoginPage login(final String username, final String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();

        return this;
    }
}
