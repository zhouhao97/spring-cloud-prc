package com.zhou;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class AppApplication {

    @Value("${name}")
    private String name;


    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AppApplication.class, args);
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        /**
         * 主要实现查看{@link org.springframework.core.env.PropertySourcesPropertyResolver}
         */
        String name_v2 = environment
                .resolvePlaceholders("${name:bootstrap}");
        System.out.println(name_v2);
        /**
         *  static修饰取值为null
         *  非static修饰能取到值
         *  static不能更据注解注入具体实现可以看{@link AutowiredAnnotationBeanPostProcessor#buildAutowiringMetadata(java.lang.Class)}
         */
        //System.out.println(name);
    }
}
