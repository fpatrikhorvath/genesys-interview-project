package com.genesys.framework.stepdefs;

import com.genesys.framework.context.ScenarioContext;
import com.genesys.framework.stores.Guru99Store;
import com.genesys.framework.stores.JsonPlaceholderStore;
import com.genesys.framework.stores.OnlineHtmlEditorStore;
import com.genesys.framework.stores.SauceDemoStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class SauceDemoSteps extends TestCore {


    public SauceDemoSteps(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                          final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                          final SauceDemoStore sauceDemoStore) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
    }

    @Given("I am on sauce login page")
    public void imOnTheSauceDemoLoginPage() {
        getSauceDemoLoginPage().open();
    }

    @And("I log in with the credentials from the json")
    public void iLogInWithTheCredentialsFromTheJson() {
        getSauceDemoLoginPage().login();
    }
}