package com.genesys.framework.stepdefs;

import com.genesys.framework.context.ScenarioContext;
import com.genesys.framework.stores.Guru99Store;
import com.genesys.framework.stores.JsonPlaceholderStore;
import com.genesys.framework.stores.OnlineHtmlEditorStore;
import com.genesys.framework.stores.SauceDemoStore;

public class Hooks extends TestCore {
    //private final WebDriverFactory webDriverFactory;

    public Hooks(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                 final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                 final SauceDemoStore sauceDemoStore) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
    }


//    @After
//    public void tearDown(final Scenario scenario) {
//
//        if (scenario.isFailed() && WebDriverInitializationListener.isInitialized()) {
//            final byte[] screenshot = ((TakesScreenshot) webDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "Screenshot");
//        }
//
//        if (WebDriverInitializationListener.isInitialized()) {
//            webDriverFactory.tearDown();
//            WebDriverInitializationListener.setIsInitialized(false);
//        }
//    }
}