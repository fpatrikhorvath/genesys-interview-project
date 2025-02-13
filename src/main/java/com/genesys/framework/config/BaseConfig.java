package com.genesys.framework.config;

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
