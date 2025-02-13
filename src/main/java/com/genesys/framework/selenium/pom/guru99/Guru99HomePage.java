package com.genesys.framework.selenium.pom.guru99;

import com.genesys.framework.config.Guru99Config;
import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class Guru99HomePage extends BasePage {
    private final Guru99Config guru99Config;

    @FindBy(how = How.ID, using = "a077aa5e")
    private WebElement iFrame;
    @FindBy(how = How.XPATH, using = "//img[@src='Jmeter720.png']")
    private WebElement jmeterImage;
    @FindBy(how = How.XPATH, using = "//h3[text()='Email Submission']")
    private WebElement emailSubmissionText;
    @FindBy(how = How.ID, using = "philadelphia-field-email")
    private WebElement emailInputField;
    @FindBy(how = How.ID, using = "philadelphia-field-submit")
    private WebElement submitButton;
    private String     originalWindow;

    protected Guru99HomePage(final WebDriverFactory driverFactory, final Guru99Config guru99Config) {
        super(driverFactory);
        this.guru99Config = guru99Config;
    }

    @Override
    public boolean isAt() {
        return false;
    }

    public void open() {
        driverFactory.getDriver().get(guru99Config.getUrl() + "/test/guru99home/");

    }

    public boolean isIframeVisible() {
        return iFrame.isDisplayed();
    }

    public Guru99HomePage clickToJmeterImage() {
        //Storing the window handle, before opening up the tab
        originalWindow = driverFactory.getDriver().getWindowHandle();

        driverFactory.getDriver().switchTo().frame(iFrame);
        jmeterImage.click();

        return this;
    }

    public Guru99HomePage closeNewlyOpenedTab() {
        driverFactory.getDriver()
                .getWindowHandles()
                .stream()
                .filter(windowHandle -> !windowHandle.equals(originalWindow))
                .findFirst()
                .ifPresent(windowHandle -> driverFactory.getDriver().switchTo().window(windowHandle));

        driverFactory.getDriver().close();
        driverFactory.getDriver().switchTo().window(originalWindow);

        return this;
    }

    public boolean isEmailSubmissionTextVisible() {
        return emailSubmissionText.isDisplayed();
    }

    public Guru99HomePage sendEmailSubmission(final String email) {
        emailInputField.sendKeys(email);
        submitButton.click();

        return this;
    }

    public String getEmailSubmissionPopUpMessage() {
        final Alert alert = driverFactory.getDriver().switchTo().alert();
        final String alertText =  alert.getText();
        alert.accept();

        return alertText;
    }
}
