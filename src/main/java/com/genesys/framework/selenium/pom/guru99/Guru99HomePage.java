package com.genesys.framework.selenium.pom.guru99;

import com.genesys.framework.config.OnlineHtmlEditorConfig;
import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class Guru99HomePage extends BasePage {
    private final OnlineHtmlEditorConfig onlineHtmlEditorConfig;

    @FindBy(how = How.XPATH, using = "//iframe")
    private WebElement iFrame;

    protected Guru99HomePage(final WebDriverFactory driverFactory, final OnlineHtmlEditorConfig onlineHtmlEditorConfig) {
        super(driverFactory);
        this.onlineHtmlEditorConfig = onlineHtmlEditorConfig;
    }

    @Override
    public boolean isAt() {
        return false;
    }

    @Override
    public void open() {
        driverFactory.getDriver().get(onlineHtmlEditorConfig.getUrl() + "/test/guru99home/");
    }


}
