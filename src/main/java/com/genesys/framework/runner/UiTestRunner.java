package com.genesys.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.genesys.framework.stepdefs"},
        tags = "@ui"
        //plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class UiTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
