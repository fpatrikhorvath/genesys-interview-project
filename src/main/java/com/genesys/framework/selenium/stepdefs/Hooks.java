package com.genesys.framework.selenium.stepdefs;

import com.genesys.framework.core.UiTestCore;
import com.genesys.framework.selenium.WebDriverFactory;

public class Hooks extends UiTestCore {
    private final WebDriverFactory webDriverFactory;

    public Hooks(final WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }
}
