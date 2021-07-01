package com.zhou.autowired;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * 主要对AutowiredAnnotationBeanPostProcessor的测试
 * 1.怎么注入到spring的
 *   1)： xml
 *   2): ComponentScan()
 *   3): ConfigurableBeanFactory.addBeanPostProcessor {@link org.springframework.beans.factory.config.ConfigurableBeanFactory#addBeanPostProcessor(org.springframework.beans.factory.config.BeanPostProcessor)}
 *     xml和componentscan最后本质还是通过addBeanPostProcessor加到spring的上下文中
 *      具体AutowiredAnnotationBeanPostProcessor如何注册参考 {@link AnnotationConfigUtils}
 *      postProcessor如何注册到应用上下文 {@link AbstractApplicationContext#registerBeanPostProcessors(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)}
 *
 *
 */
public class Inject_1 {
    public static void main(String[] args) throws NoSuchMethodException {
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();

        Method buildAutowiringMetadata = autowiredAnnotationBeanPostProcessor.getClass().
                getDeclaredMethod("buildAutowiringMetadata", Class.class);
        buildAutowiringMetadata.setAccessible(true);

        //调用方法
        InjectionMetadata injectionMetadata = (InjectionMetadata) ReflectionUtils.invokeMethod(buildAutowiringMetadata, autowiredAnnotationBeanPostProcessor, User.class);
        /**
         * 方法私有这里直接说下结构
         *
         * InjectionMetadata - > injectedElements[list] -> InjectedElement
         *
         * 主要解析了非static的字段和方法
         *
         */
        System.out.println(injectionMetadata);

        System.out.println(System.getProperty("user.dir"));

    }

}
