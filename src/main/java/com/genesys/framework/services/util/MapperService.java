package com.genesys.framework.services.util;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.ScenarioScope;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@ScenarioScope
public class MapperService {
    private static final ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> mutateObjectList(final String body, final Class<T> clazz) {
        try {
            return mapper.readValue(body, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}