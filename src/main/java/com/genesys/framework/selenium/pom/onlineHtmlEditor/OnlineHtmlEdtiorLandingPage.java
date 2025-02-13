package com.genesys.framework.selenium.pom.onlineHtmlEditor;

import com.genesys.framework.config.OnlineHtmlEditorConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class OnlineHtmlEdtiorLandingPage extends BasePage {
    private final OnlineHtmlEditorConfig onlineHtmlEditorConfig;

    @FindBy(how = How.XPATH, using = "//div[@role='textbox']")
    private WebElement editorTextArea;
    @FindBy(how = How.XPATH, using = "//button[@data-cke-tooltip-text='Bold (Ctrl+B)']")
    private WebElement boldTypingButton;
    @FindBy(how = How.XPATH, using = "//button[@data-cke-tooltip-text='Underline (Ctrl+U)']")
    private WebElement underlineTypingButton;
    @FindBy(how = How.XPATH, using = "//strong/u[text()='Automation Test Example']")
    private WebElement expectedBoldAndUnderlinedText;

    protected OnlineHtmlEdtiorLandingPage(final WebDriverFactory driverFactory, final OnlineHtmlEditorConfig onlineHtmlEditorConfig) {
        super(driverFactory);
        this.onlineHtmlEditorConfig = onlineHtmlEditorConfig;
    }

    @Override
    public boolean isAt() {
        return editorTextArea.isDisplayed();
    }

    @Override
    public void open() {
        driverFactory.getDriver().get(onlineHtmlEditorConfig.getUrl());
    }

    public OnlineHtmlEdtiorLandingPage applyFormatting(final String formatting) {
        switch (formatting) {
            case "bold" -> boldTypingButton.click();
            case "underline" -> underlineTypingButton.click();
            default -> {
                throw new RuntimeException(formatting + " is not an option!");
            }
        }

        return this;
    }

    public OnlineHtmlEdtiorLandingPage enterText(final String text) {
        editorTextArea.sendKeys(text);

        return this;
    }

    public OnlineHtmlEdtiorLandingPage selectAllText() {
        editorTextArea.sendKeys(Keys.CONTROL + "a");

        return this;
    }

    public boolean isFormattedTextVisible() {
        return expectedBoldAndUnderlinedText.isDisplayed();
    }
}
