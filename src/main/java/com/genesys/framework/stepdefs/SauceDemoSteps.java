package com.genesys.framework.stepdefs;

import com.genesys.framework.config.SauceDemoCredConfig;
import com.genesys.framework.context.ScenarioContext;
import com.genesys.framework.services.SauceDemoCredJsonReaderService;
import com.genesys.framework.stores.Guru99Store;
import com.genesys.framework.stores.JsonPlaceholderStore;
import com.genesys.framework.stores.OnlineHtmlEditorStore;
import com.genesys.framework.stores.SauceDemoStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SauceDemoSteps extends TestCore {
    private final SauceDemoCredJsonReaderService sauceDemoCredJsonReaderService;

    public SauceDemoSteps(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                          final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                          final SauceDemoStore sauceDemoStore, final SauceDemoCredJsonReaderService sauceDemoCredJsonReaderService) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
        this.sauceDemoCredJsonReaderService = sauceDemoCredJsonReaderService;
    }


    @Given("I am on the sauce inventory page")
    public void imOnTheSauceDemoInventoryPage() {
        getSauceDemoInventoryPage().open();
    }

    @And("I log in with the credentials from the json")
    public void iLogInWithTheCredentialsFromTheJson() throws IOException {
        final SauceDemoCredConfig sauceDemoCredConfig = sauceDemoCredJsonReaderService.readJsonFile();
        getSauceDemoLoginPage().loginByType(sauceDemoCredConfig.getUsername(), sauceDemoCredConfig.getPassword());
    }

    @When("I select the {word} item")
    public void iSelectTheItem(final String item) {
        getSauceDemoInventoryPage().selectItem(item);
    }

    @Then("validate that the number of the selected items is {int}")
    public void validateThatTheNumberOfTheSelectedItemsIs(final int numOfIems) {
        assertThat(getSauceDemoInventoryPage().getNumberOnCartIcon())
                .withFailMessage("Number of items on the cart badge").isEqualTo(numOfIems);
    }

    @When("I go through the check process")
    public void iGoThroughTheCheckProcess() {
        getSauceDemoInventoryPage().clickOnTheChartIcon();
        getSauceDemoCartPage().clickOnCheckout();

        getSauceDemoCheckoutStepOnePage().fillForm("Tihamer", "Test", "5700");
        getSauceDemoCheckoutStepTwoPage().clickFinishButton();
    }

    @Then("validate that the checkout process was successful")
    public void validateThatTheCheckoutProcessWasSuccessful() {
        assertThat(getSauceDemoCheckoutCompletePage().isAt())
                .withFailMessage("Checkout process completed page is not present").isTrue();
    }

    @And("I log in as {word} user")
    public void iLogInAsStandardUser(final String userType) {
        getSauceDemoLoginPage().loginByType(userType);
    }

    @Then("validate that the footer message contains {string}")
    public void validateThatTheFooterMessageContains(final String expectedText) {
        final String footerMessage = getSauceDemoInventoryPage().getFooterMessage();
        assertThat(footerMessage)
                .withFailMessage("Validating the footer message")
                .contains(expectedText);
    }

    @And("I scroll to the footer")
    public void iScrollToTheFooter() {
        getSauceDemoInventoryPage().scrollToFooter();
    }

}