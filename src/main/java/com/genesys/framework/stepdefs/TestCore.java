package com.genesys.framework.stepdefs;

import com.genesys.framework.context.ScenarioContext;
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

    protected final ScenarioContext scenarioContext;

    private final Guru99Store          guru99Store;
    private final JsonPlaceholderStore  jsonPlaceholderStore;
    private final OnlineHtmlEditorStore onlineHtmlEditorStore;
    private final SauceDemoStore        sauceDemoStore;


    public TestCore(final ScenarioContext scenarioContext, final Guru99Store guru99Store,
                    final JsonPlaceholderStore jsonPlaceholderStore, final OnlineHtmlEditorStore onlineHtmlEditorStore,
                    final SauceDemoStore sauceDemoStore) {
        this.scenarioContext       = scenarioContext;
        this.guru99Store           = guru99Store;
        this.jsonPlaceholderStore  = jsonPlaceholderStore;
        this.onlineHtmlEditorStore = onlineHtmlEditorStore;
        this.sauceDemoStore        = sauceDemoStore;
    }
}
