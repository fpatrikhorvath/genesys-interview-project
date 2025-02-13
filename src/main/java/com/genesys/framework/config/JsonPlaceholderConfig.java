package com.genesys.framework.config;

import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Scope(SCOPE_CUCUMBER_GLUE)
public class JsonPlaceholderConfig extends BaseConfig {
    protected JsonPlaceholderConfig(final String protocol, final String ip) {
        super(protocol, ip);
    }
}
