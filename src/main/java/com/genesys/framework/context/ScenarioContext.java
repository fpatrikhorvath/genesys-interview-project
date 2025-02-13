package com.genesys.framework.context;


import com.genesys.framework.services.util.MapperService;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@ScenarioScope
public class ScenarioContext {
    private final MapperService           mapperService;
    private final HashMap<String, Object> contextObjectMap = new HashMap<>();


    public ScenarioContext(final MapperService mapperService) {
        this.mapperService = mapperService;
    }

    public void storeContextObject(final String key, final Object object) {
        contextObjectMap.put(key, object);
    }

    public Object getContextObject(final String key) {
        return contextObjectMap.get(key);
    }
}