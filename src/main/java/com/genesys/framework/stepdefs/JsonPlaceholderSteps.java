package com.genesys.framework.stepdefs;

import com.genesys.framework.context.ScenarioContext;
import com.genesys.framework.rest.response.User;
import com.genesys.framework.stores.Guru99Store;
import com.genesys.framework.stores.JsonPlaceholderStore;
import com.genesys.framework.stores.OnlineHtmlEditorStore;
import com.genesys.framework.stores.SauceDemoStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonPlaceholderSteps extends TestCore {
    private static final Logger LOG = LogManager.getLogger(TestCore.class);

    public JsonPlaceholderSteps(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                                final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore, final SauceDemoStore sauceDemoStore) {
        super(scenarioContext, guru99Store, jsonPlaceholderStore, onlineHtmlEditorStore, sauceDemoStore);
    }


    @When("I query all the users and store as {word}")
    public void iQueryAllTheUsers(final String identifier) throws IOException {
        final List<User> users = getUserService().getUsers();
        scenarioContext.storeContextUserList(identifier, users);
    }

    @Then("I log {word}")
    public void iLog(final String identifier) {
        final List<User> users = scenarioContext.getContextObject(identifier);
        for (User u : users) {
            LOG.info(u.getName() + " | " + u.getEmail());
        }
    }

    @And("validate the first email of {word} contains {word}")
    public void validateTheFirstEmailOfContains(final String identifier, final String filterChar) {
       final User firstUser = scenarioContext.getContextObject(identifier).get(0);
       assertThat(firstUser.getEmail()).withFailMessage("Filter character is not in the email")
               .contains(filterChar);
    }
}