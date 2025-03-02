package com.genesys.framework.stepdefs;

import com.genesys.framework.context.ScenarioContext;
import com.genesys.framework.rest.UserService.UserService;
import com.genesys.framework.selenium.pom.guru99.Guru99HomePage;
import com.genesys.framework.selenium.pom.guru99.Guru99NavBar;
import com.genesys.framework.selenium.pom.guru99.Guru99TooltipPage;
import com.genesys.framework.selenium.pom.onlineHtmlEditor.OnlineHtmlEdtiorLandingPage;
import com.genesys.framework.selenium.pom.sauceDemo.*;
import com.genesys.framework.stores.Guru99Store;
import com.genesys.framework.stores.JsonPlaceholderStore;
import com.genesys.framework.stores.OnlineHtmlEditorStore;
import com.genesys.framework.stores.SauceDemoStore;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration(loader = SpringBootContextLoader.class, value = {"classpath:spring.xml"})
@SpringBootTest(classes = TestCore.class)
public class TestCore {

    protected final ScenarioContext       scenarioContext;
    private final   Guru99Store           guru99Store;
    private final   JsonPlaceholderStore  jsonPlaceholderStore;
    private final   OnlineHtmlEditorStore onlineHtmlEditorStore;
    private final   SauceDemoStore        sauceDemoStore;


    public TestCore(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                    final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                    final SauceDemoStore sauceDemoStore) {
        this.scenarioContext       = scenarioContext;
        this.guru99Store           = guru99Store;
        this.jsonPlaceholderStore  = jsonPlaceholderStore;
        this.onlineHtmlEditorStore = onlineHtmlEditorStore;
        this.sauceDemoStore        = sauceDemoStore;
    }

    protected SauceDemoLoginPage getSauceDemoLoginPage() {
        return sauceDemoStore.getSauceDemoLoginPage();
    }

    protected SauceDemoInventoryPage getSauceDemoInventoryPage() {
        return sauceDemoStore.getSauceDemoInventoryPage();
    }

    protected SauceDemoCartPage getSauceDemoCartPage() {
        return sauceDemoStore.getSauceDemoCartPage();
    }

    protected SauceDemoCheckoutStepOnePage getSauceDemoCheckoutStepOnePage() {
        return sauceDemoStore.getSauceDemoCheckoutStepOnePage();
    }

    protected SauceDemoCheckoutStepTwoPage getSauceDemoCheckoutStepTwoPage() {
        return sauceDemoStore.getSauceDemoCheckoutStepTwoPage();
    }

    protected SauceDemoCheckoutCompletePage getSauceDemoCheckoutCompletePage() {
        return sauceDemoStore.getSauceDemoCheckoutCompletePage();
    }

    protected OnlineHtmlEdtiorLandingPage getOnlineHtmlEdtiorLandingPage() {
        return onlineHtmlEditorStore.getOnlineHtmlEdtiorLandingPage();
    }

    protected Guru99HomePage getGuru99HomePage() {
        return guru99Store.getGuru99HomePage();
    }
    protected Guru99NavBar getGuru99NavBar() {
        return guru99Store.getGuru99NavBar();
    }
    protected Guru99TooltipPage getGuru99TooltipPage() {
        return guru99Store.getGuru99TooltipPage();
    }

    protected UserService getUserService() {
        return jsonPlaceholderStore.getUserService();
    }

}
