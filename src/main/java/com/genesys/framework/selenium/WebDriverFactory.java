package com.genesys.framework.selenium;

import com.genesys.framework.config.SeleniumConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class WebDriverFactory {
    private static final Logger         logger = LogManager.getLogger(WebDriverFactory.class);
    private static       WebDriver      driver;
    private final        SeleniumConfig seleniumConfig;

    public WebDriverFactory(final SeleniumConfig seleniumConfig) {
        this.seleniumConfig = seleniumConfig;
    }

    private void init() {
        logger.info("Initializing the {} driver", seleniumConfig.getBrowserType());

        switch (seleniumConfig.getBrowserType()) {
            case "chrome" -> driver = initChromeDriver();
            case "firefox" -> driver = initFirefoxDriver();
            default -> throw new RuntimeException("The given browser is not an option!");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(seleniumConfig.getTimeout(), TimeUnit.SECONDS);

        logger.info("Chrome driver initialized: {}", WebDriverInitializationListener.isInitialized());
    }

    private ChromeDriver initChromeDriver() {
        final ChromeOptions options = new ChromeOptions();

        if (seleniumConfig.isHeadless()) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    private FirefoxDriver initFirefoxDriver() {
        final FirefoxOptions options = new FirefoxOptions();

        if (seleniumConfig.isHeadless()) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }

    public void tearDown() {
        if (WebDriverInitializationListener.isInitialized()) {
            driver.quit();
            WebDriverInitializationListener.setIsInitialized(false);
        }
    }

    public WebDriver getDriver() {
        if (!WebDriverInitializationListener.isInitialized()) {
            WebDriverInitializationListener.setIsInitialized(true);
            init();
        }
        return driver;
    }
}