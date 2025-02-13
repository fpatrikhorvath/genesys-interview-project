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

public class Guru99Steps extends TestCore {


    public Guru99Steps(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                       final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                       final SauceDemoStore sauceDemoStore) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
    }

    @Given("I am on the guru99 home page")
    public void iAmOnTheGuru99HomePage() {
        getGuru99HomePage().open();
    }

    @Then("validate that the guru99 IFrame is visible")
    public void validateThatTheGuru99IFrameIsVisible() {
        assertThat(getGuru99HomePage().isIframeVisible())
                .withFailMessage("iframe is not visible")
                .isTrue();
    }

    @When("I click on the jmeter image")
    public void iClickOnTheJmeterImage() {
        getGuru99HomePage().clickToJmeterImage();
    }

    @And("I close the newly opened tab")
    public void iCloseTheNewlyOpenedTab() {
        getGuru99HomePage().closeNewlyOpenedTab();
    }

    @Then("validate that the email submission text is visible")
    public void validateThatTheEmailSubmissionTextIsVisible() {
        assertThat(getGuru99HomePage().isEmailSubmissionTextVisible())
                .withFailMessage("Email submission text not visible")
                .isTrue();
    }

    @When("I send the email submission")
    public void iSendTheEmailSubmission() {
        getGuru99HomePage().sendEmailSubmission("test@test.com");
    }

    @Then("I validate that the pop up message contains {string}")
    public void iValidateThatThePopUpMessageContains(final String expectedText) {
        final String popUpText = getGuru99HomePage().getEmailSubmissionPopUpMessage();
        assertThat(popUpText).withFailMessage("Verify popup message contains the given word")
                .contains(expectedText);
    }

    @When("I click on {word} dropdown and choose the {word} option")
    public void iClickOnDropdownAndChooseTheOption(final String dropdown, final String option) {
        getGuru99NavBar()
                .clickToDropdown(dropdown)
                .clickToDropdownOption(option);
    }

    @Then("validate the tooltip page contains the download now button")
    public void validateTheTooltipPageContainsTheDownloadNowButton() {
        assertThat(getGuru99TooltipPage().isAt())
                .withFailMessage("Verify that the tooltip page is visible")
                .isTrue();
    }

}