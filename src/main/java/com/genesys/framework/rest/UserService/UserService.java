package com.genesys.framework.rest.UserService;

import com.genesys.framework.rest.client.UserClient;
import com.genesys.framework.rest.response.User;
import io.cucumber.spring.ScenarioScope;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@ScenarioScope
public class UserService {
    private static final Logger LOG = LogManager.getLogger(UserService.class);

    private final UserClient userClient;

    public UserService(final UserClient userClient) {
        this.userClient = userClient;
    }
    public List<User> getUsers() throws IOException {
        return userClient.getUsers();
    }
}
