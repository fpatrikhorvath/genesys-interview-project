package com.genesys.framework.config;

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
