package com.genesys.framework.stores;

import com.genesys.framework.selenium.pom.SauceDemoLoginPage;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class SauceDemoStore {
    private final SauceDemoLoginPage sauceDemoLoginPage;

    public SauceDemoStore(final SauceDemoLoginPage swagLabsLoginPage) {
        this.sauceDemoLoginPage = swagLabsLoginPage;
    }
    public SauceDemoLoginPage getSauceDemoLoginPage(){
        return sauceDemoLoginPage;
    }
}
