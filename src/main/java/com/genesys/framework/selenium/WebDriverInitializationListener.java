package com.genesys.framework.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class WebDriverInitializationListener {
    private static final Logger logger = LogManager.getLogger(WebDriverInitializationListener.class);

    private static AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static AtomicBoolean isUiTest      = new AtomicBoolean(false);

    public static boolean isInitialized() {
        return isInitialized.get();
    }

    public static void setIsInitialized(final boolean initialized) {
        isInitialized.set(initialized);
        logger.info("Webdriver initialization status set to: {}", isInitialized);
    }

    //TODO: do we need this?
    public static boolean isUiTest() {
        return isUiTest.get();
    }

    public static void setIsUiTest(final boolean initialized) {
        logger.info("The given test is a UI test: {}", isInitialized);
        isUiTest.set(initialized);
    }
}