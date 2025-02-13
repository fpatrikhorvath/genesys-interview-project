package com.genesys.framework.selenium.pom;

import com.genesys.framework.config.Guru99Config;
import com.genesys.framework.selenium.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class SwagLabsLoginPage extends BasePage {
    private final Guru99Config guru99Config;
    @FindBy(how = How.ID, using = "username-name")
    private       WebElement   usernameInputField;
    @FindBy(how = How.ID, using = "password")
    private       WebElement   passwordInputField;
    @FindBy(how = How.ID, using = "login-button")
    private       WebElement   loginButton;

    protected SwagLabsLoginPage(final WebDriverFactory driverFactory, final Guru99Config guru99Config) {
        super(driverFactory);
        this.guru99Config = guru99Config;
    }

    @Override
    protected boolean isAt() {
        return loginButton.isDisplayed();
    }

    public void open() {
        driverFactory.getDriver().get(guru99Config.getUrl());
    }

    public SwagLabsLoginPage login(final String username, final String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();

        return this;
    }
}
