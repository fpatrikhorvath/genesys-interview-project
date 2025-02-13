package com.genesys.framework.stores;

import com.genesys.framework.rest.UserService.UserService;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class JsonPlaceholderStore {
    private final UserService userService;

    public JsonPlaceholderStore(final UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
