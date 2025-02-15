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
public class SauceDemoLoginPage extends BasePage {
    private final SauceDemoConfig sauceDemoConfig;
    @FindBy(how = How.ID, using = "user-name")
    private       WebElement      usernameInputField;
    @FindBy(how = How.ID, using = "password")
    private       WebElement      passwordInputField;
    @FindBy(how = How.ID, using = "login-button")
    private       WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//h3[text()='Epic sadface: Username is required']")
    private       WebElement incorrectCredsErrorMessage;

    protected SauceDemoLoginPage(final WebDriverFactory driverFactory, final SauceDemoConfig sauceDemoConfig) {
        super(driverFactory);
        this.sauceDemoConfig = sauceDemoConfig;
    }

    @Override
    public boolean isAt() {
        return loginButton.isDisplayed();
    }

    public SauceDemoLoginPage enterUsername(final String username) {
        usernameInputField.sendKeys(username);

        return this;
    }

    public SauceDemoLoginPage enterPassword(final String password) {
        passwordInputField.sendKeys(password);

        return this;
    }

    public SauceDemoLoginPage clickToLogin() {
        loginButton.click();

        return this;
    }

    public SauceDemoLoginPage loginByType(final String type) {
        switch (type) {
            case "standard":
                usernameInputField.sendKeys(sauceDemoConfig.getUsername());
                passwordInputField.sendKeys(sauceDemoConfig.getPassword());
                break;
//            case "other":
//                usernameInputField.sendKeys(sauceDemoConfig.getUsername());
//                passwordInputField.sendKeys(sauceDemoConfig.getPassword());
//                break;
            default:
                throw new RuntimeException(type + " is not an option!");
        }
        loginButton.click();

        return this;
    }

    public boolean isLoginFailedErrorDisplayed() {
        return incorrectCredsErrorMessage.isDisplayed();
    }
}
