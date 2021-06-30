package com.zhou.bootstrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * 这里不用注册进去也可以
 * 具体实现{@link org.springframework.boot.SpringApplication#initializers}
 *
 */

//@Component
public class CustomEnvirment_v2 implements PropertySourceLocator {
    @Override
    public PropertySource<?> locate(Environment environment) {
        if(environment instanceof ConfigurableEnvironment){
            Map<String,Object> property = new HashMap<>();
            property.put("name","zhouzaza");
            MapPropertySource mapPropertySource = new MapPropertySource("custom-envirment_v2", property);
            ((ConfigurableEnvironment)environment).getPropertySources().addFirst(mapPropertySource);
        }
        //return new MapPropertySource("custom-envirment_v2", Collections.singletonMap("name","zhouzaza"));
        return null;
    }
}
