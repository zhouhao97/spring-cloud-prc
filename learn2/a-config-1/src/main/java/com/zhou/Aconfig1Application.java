package com.zhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 一个server onfig的配置中心
 */
@SpringBootApplication
@EnableConfigServer
public class Aconfig1Application {

    public static void main(String[] args) {
        SpringApplication.run(Aconfig1Application.class,args);
    }

}
