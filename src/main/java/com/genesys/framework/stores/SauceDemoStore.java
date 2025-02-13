package com.genesys.framework.stores;

import com.genesys.framework.selenium.pom.*;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class SauceDemoStore {
    private final SauceDemoLoginPage            sauceDemoLoginPage;
    private final SauceDemoInventoryPage        sauceDemoInventoryPage;
    private final SauceDemoCartPage             sauceDemoCartPage;
    private final SauceDemoCheckoutStepOnePage  sauceDemoCheckoutStepOnePage;
    private final SauceDemoCheckoutStepTwoPage  sauceDemoCheckoutStepTwoPage;
    private final SauceDemoCheckoutCompletePage sauceDemoCheckoutCompletePage;

    public SauceDemoStore(final SauceDemoLoginPage swagLabsLoginPage, final SauceDemoInventoryPage sauceDemoInventoryPage,
                          final SauceDemoCartPage sauceDemoCartPage, final SauceDemoCheckoutStepOnePage sauceDemoCheckoutStepOnePage, final SauceDemoCheckoutStepTwoPage sauceDemoCheckoutStepTwoPage, final SauceDemoCheckoutCompletePage sauceDemoCheckoutCompletePage) {
        this.sauceDemoLoginPage            = swagLabsLoginPage;
        this.sauceDemoInventoryPage        = sauceDemoInventoryPage;
        this.sauceDemoCartPage             = sauceDemoCartPage;
        this.sauceDemoCheckoutStepOnePage  = sauceDemoCheckoutStepOnePage;
        this.sauceDemoCheckoutStepTwoPage  = sauceDemoCheckoutStepTwoPage;
        this.sauceDemoCheckoutCompletePage = sauceDemoCheckoutCompletePage;
    }

    public SauceDemoLoginPage getSauceDemoLoginPage() {
        return sauceDemoLoginPage;
    }

    public SauceDemoInventoryPage getSauceDemoInventoryPage() {
        return sauceDemoInventoryPage;
    }

    public SauceDemoCartPage getSauceDemoCartPage() {
        return sauceDemoCartPage;
    }

    public SauceDemoCheckoutStepOnePage getSauceDemoCheckoutStepOnePage() {
        return sauceDemoCheckoutStepOnePage;
    }

    public SauceDemoCheckoutStepTwoPage getSauceDemoCheckoutStepTwoPage() {
        return sauceDemoCheckoutStepTwoPage;
    }

    public SauceDemoCheckoutCompletePage getSauceDemoCheckoutCompletePage() {
        return sauceDemoCheckoutCompletePage;
    }
}
