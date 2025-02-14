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

public class OnlineHtmlEditorSteps extends TestCore {


    public OnlineHtmlEditorSteps(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                                 final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore, final SauceDemoStore sauceDemoStore) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
    }

    @Given("I am on the rich text editor page")
    public void iAmOnTheRichTextEditorPage() {
        getOnlineHtmlEdtiorLandingPage().open();
    }

    @When("I type in the {string} to the editor")
    public void iTypeInTheAutomationTestExample(final String text) {
        getOnlineHtmlEdtiorLandingPage().enterText(text);
    }

    @And("I select all the text in the editor")
    public void iSelectAllTheTextInTheEditor() {
        getOnlineHtmlEdtiorLandingPage().selectAllText();
    }

    @And("I apply {word} formatting on the editor")
    public void iApplyBoldFormattingOnTheEditor(final String formatting) {
        getOnlineHtmlEdtiorLandingPage().applyFormatting(formatting);
    }

    @Then("validate that the formatted text is in the text editor")
    public void validateThatTheTextIsInTheTextEditor() {
        assertThat(getOnlineHtmlEdtiorLandingPage().isFormattedTextVisible())
                .withFailMessage("Fully formatted text is missing")
                .isTrue();
    }
}