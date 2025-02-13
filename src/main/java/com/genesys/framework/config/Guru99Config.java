package com.genesys.framework.config;

import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Scope(SCOPE_CUCUMBER_GLUE)
public class Guru99Config extends BaseConfig {
    private final String basePath;

    protected Guru99Config(final String protocol, final String ip, final String basePath) {
        super(protocol, ip);
        this.basePath = basePath;
    }

    public String getUrl() {
        return protocol + "://" + ip + basePath;
    }

}
