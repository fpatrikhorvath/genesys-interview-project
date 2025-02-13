package com.genesys.framework.config;

public class SauceDemoConfig extends BaseConfig {
    private final String basePath;

    protected SauceDemoConfig(final String protocol, final String ip, final String basePath) {
        super(protocol, ip);
        this.basePath = basePath;
    }

    public String getUrl() {
        return protocol + "://" + ip + basePath;
    }
}
