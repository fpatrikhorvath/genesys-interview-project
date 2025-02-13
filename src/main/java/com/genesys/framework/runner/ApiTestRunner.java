package com.genesys.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"classpath:features/user-layer"},
        glue = {"com.genesys.framework.stepdefs"}
        //plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
