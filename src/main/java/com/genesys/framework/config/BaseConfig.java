package com.genesys.framework.config;

import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Scope(SCOPE_CUCUMBER_GLUE)
public abstract class BaseConfig {
    protected final String protocol;
    protected final String ip;

    protected BaseConfig(final String protocol, final String ip) {
        this.protocol = protocol;
        this.ip       = ip;
    }

    public String getUrl() {
        return protocol + "://" + ip;
    }
}
