package com.genesys.framework.rest.client;

import com.genesys.framework.config.JsonPlaceholderConfig;
import com.genesys.framework.rest.RestClient;
import com.genesys.framework.rest.response.User;
import com.genesys.framework.services.util.MapperService;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@ScenarioScope
public class UserClient {
    private static final String GET_USER_PATH = "/users";

    private final JsonPlaceholderConfig jsonPlaceholderConfig;
    private final MapperService         mapperService;
    private final RestClient            restClient;

    public UserClient(final JsonPlaceholderConfig jsonPlaceholderConfig, final MapperService mapperService) {
        this.jsonPlaceholderConfig = jsonPlaceholderConfig;
        this.mapperService         = mapperService;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        this.restClient = new RestClient(jsonPlaceholderConfig.getUrl(), headers);

    }


    public List<User> getUsers() throws IOException {
        return mapperService.mutateObjectList(restClient.GET(GET_USER_PATH), User.class);
    }
}
