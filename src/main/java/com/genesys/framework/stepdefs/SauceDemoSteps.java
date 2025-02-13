package com.genesys.framework.stepdefs;

import com.genesys.framework.context.ScenarioContext;
import com.genesys.framework.stores.Guru99Store;
import com.genesys.framework.stores.JsonPlaceholderStore;
import com.genesys.framework.stores.OnlineHtmlEditorStore;
import com.genesys.framework.stores.SauceDemoStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SauceDemoSteps extends TestCore {


    public SauceDemoSteps(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                          final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                          final SauceDemoStore sauceDemoStore) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
    }

    @Given("I am on sauce inventory page")
    public void imOnTheSauceDemoInventoryPage() {
        getSauceDemoInventoryPage().open();
    }

    @And("I log in with the credentials from the json")
    public void iLogInWithTheCredentialsFromTheJson() {
        getSauceDemoLoginPage().login();
    }

    @When("I select the {}")
    public void iSelectTheSauceLabsBackpack(final String item) {
       getSauceDemoInventoryPage().selectItem(item);
    }

    @Then("validate that the number of the selected items is {int}")
    public void validateThatTheNumberOfTheSelectedItemsIs(final int numOfIems) {
        assertThat(getSauceDemoInventoryPage().getNumberOnCartIcon())
                .withFailMessage("Number of items on the cart badge").isEqualTo(numOfIems);
    }
}