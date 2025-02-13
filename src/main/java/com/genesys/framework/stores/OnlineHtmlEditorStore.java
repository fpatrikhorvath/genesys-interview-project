package com.genesys.framework.stores;

import com.genesys.framework.selenium.pom.onlineHtmlEditor.OnlineHtmlEdtiorLandingPage;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class OnlineHtmlEditorStore {
    private final OnlineHtmlEdtiorLandingPage onlineHtmlEdtiorLandingPage;

    public OnlineHtmlEditorStore(final OnlineHtmlEdtiorLandingPage onlineHtmlEdtiorLandingPage) {
        this.onlineHtmlEdtiorLandingPage = onlineHtmlEdtiorLandingPage;
    }

    public OnlineHtmlEdtiorLandingPage getOnlineHtmlEdtiorLandingPage() {
        return onlineHtmlEdtiorLandingPage;
    }
}
