package com.genesys.framework.stepdefs;

import com.genesys.framework.context.ScenarioContext;
import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.WebDriverInitializationListener;
import com.genesys.framework.stores.Guru99Store;
import com.genesys.framework.stores.JsonPlaceholderStore;
import com.genesys.framework.stores.OnlineHtmlEditorStore;
import com.genesys.framework.stores.SauceDemoStore;
import io.cucumber.java.After;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Hooks extends TestCore {
    private final WebDriverFactory webDriverFactory;

    public Hooks(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                 final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                 final SauceDemoStore sauceDemoStore, final WebDriverFactory webDriverFactory) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
        this.webDriverFactory = webDriverFactory;
    }


    @After
    public void tearDown(){
        webDriverFactory.tearDown();
    }
}