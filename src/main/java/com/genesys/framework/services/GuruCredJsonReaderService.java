package com.genesys.framework.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesys.framework.config.Guru99CredConfig;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class GuruCredJsonReaderService {
    private static final String PATH = "src/test/resources/guru99-credential.json";

    public Guru99CredConfig readJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File         jsonFile     = new File(PATH);

        return objectMapper.readValue(jsonFile, Guru99CredConfig.class);
    }
}
