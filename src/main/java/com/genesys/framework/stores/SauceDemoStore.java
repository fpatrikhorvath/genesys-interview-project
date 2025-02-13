package com.genesys.framework.stores;

import com.genesys.framework.selenium.pom.SwagLabsLoginPage;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class SauceDemoStore {
    private final SwagLabsLoginPage swagLabsLoginPage;

    public SauceDemoStore(final SwagLabsLoginPage swagLabsLoginPage) {
        this.swagLabsLoginPage = swagLabsLoginPage;
    }
    public SwagLabsLoginPage getSwagLabsLoginPage(){
        return swagLabsLoginPage;
    }
}
