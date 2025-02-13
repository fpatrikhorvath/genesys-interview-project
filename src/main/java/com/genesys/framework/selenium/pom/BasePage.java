package com.genesys.framework.selenium.pom;

import com.genesys.framework.selenium.WebDriverFactory;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriverFactory driverFactory;

    protected BasePage(final WebDriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @PostConstruct
    private void init() {
        PageFactory.initElements(driverFactory.getDriver(), this);
    }

    protected abstract boolean isAt();

    protected abstract void open();

}