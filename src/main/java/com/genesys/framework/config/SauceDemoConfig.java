package com.genesys.framework.config;

import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Scope(SCOPE_CUCUMBER_GLUE)
public class SauceDemoConfig extends BaseConfig {
    private final String username;
    private final String password;

    protected SauceDemoConfig(final String protocol, final String ip, final String username, final String password) {
        super(protocol, ip);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
