package com.genesys.framework.selenium.pom;

import com.genesys.framework.selenium.WebDriverFactory;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriverFactory   driverFactory;
    protected final JavascriptExecutor jsExcecutor;

    protected BasePage(final WebDriverFactory driverFactory) {
        this.driverFactory = driverFactory;
        this.jsExcecutor   = (JavascriptExecutor) driverFactory.getDriver();
    }

    @PostConstruct
    private void init() {
        PageFactory.initElements(driverFactory.getDriver(), this);
    }

    public abstract boolean isAt();

}