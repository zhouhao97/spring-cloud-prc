package com.zhou.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class User {
    @Autowired
    //@Value("${name}")
    private String name;
    @Value("${sex}")
    private String sex;
    @Value("${health}")
    private static String health;
    private static String hobby;

    public String getHobby() {
        return hobby;
    }
    @Value("${hobby}")
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
