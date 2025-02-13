package com.genesys.framework.stores;

import com.genesys.framework.selenium.pom.SauceDemoInventoryPage;
import com.genesys.framework.selenium.pom.SauceDemoLoginPage;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class SauceDemoStore {
    private final SauceDemoLoginPage     sauceDemoLoginPage;
    private final SauceDemoInventoryPage sauceDemoInventoryPage;

    public SauceDemoStore(final SauceDemoLoginPage swagLabsLoginPage, final SauceDemoInventoryPage sauceDemoInventoryPage) {
        this.sauceDemoLoginPage = swagLabsLoginPage;
        this.sauceDemoInventoryPage = sauceDemoInventoryPage;
    }
    public SauceDemoLoginPage getSauceDemoLoginPage(){
        return sauceDemoLoginPage;
    }

    public SauceDemoInventoryPage getSauceDemoInventoryPage() {
        return sauceDemoInventoryPage;
    }
}
