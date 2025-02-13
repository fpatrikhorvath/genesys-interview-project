package com.genesys.framework.selenium.pom;

import com.genesys.framework.config.SauceDemoConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class SauceDemoCheckoutStepOnePage extends BasePage {
    private final SauceDemoConfig sauceDemoConfig;

    @FindBy(how = How.ID, using = "first-name")
    private WebElement firstNameInputField;
    @FindBy(how = How.ID, using = "last-name")
    private WebElement lastNameInputField;
    @FindBy(how = How.ID, using = "postal-code")
    private WebElement postalCodeInputField;
    @FindBy(how = How.ID, using = "continue")
    private WebElement continueButton;
    protected SauceDemoCheckoutStepOnePage(final WebDriverFactory driverFactory, final SauceDemoConfig sauceDemoConfig) {
        super(driverFactory);
        this.sauceDemoConfig = sauceDemoConfig;
    }

    @Override
    public boolean isAt() {
        return firstNameInputField.isDisplayed();
    }

    @Override
    public void open(){

    }

    public SauceDemoCheckoutStepOnePage fillForm(final String firstName, final String lastName, final String postalCode){
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        postalCodeInputField.sendKeys(postalCode);
        continueButton.click();

        return this;
    }
}
