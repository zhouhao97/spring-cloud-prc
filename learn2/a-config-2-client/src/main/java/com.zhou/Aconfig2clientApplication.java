package com.zhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 一个server config的客户端
 */
@SpringBootApplication
@RestController
public class Aconfig2clientApplication {

    @RequestMapping("sysuser/info")
    public Map getSysUserinfo(){

        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(Aconfig2clientApplication.class,args);
    }

}
