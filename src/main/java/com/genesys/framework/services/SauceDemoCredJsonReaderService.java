package com.genesys.framework.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesys.framework.config.SauceDemoCredConfig;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class SauceDemoCredJsonReaderService {
    private static final String PATH = "src/main/resources/sauce-demo-credential.json";

    public SauceDemoCredConfig readJsonFile() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final File         jsonFile     = new File(PATH);

        return objectMapper.readValue(jsonFile, SauceDemoCredConfig.class);
    }
}
