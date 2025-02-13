package com.genesys.framework.context;


import com.genesys.framework.rest.response.User;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@ScenarioScope
public class ScenarioContext {
    private final HashMap<String, List<User>> contextUserList = new HashMap<>();


    public void storeContextUserList(final String key, final List<User> userList) {
        contextUserList.put(key, userList);
    }

    public List<User> getContextObject(final String key) {
        return contextUserList.get(key);
    }
}