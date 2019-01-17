package com.gorden5566.framework.spring;

import com.gorden5566.framework.spring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class TestSpring {
    private static AnnotationConfigApplicationContext context;

    static {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public static void main(String[] args) {
        // Spring和Mybatis整合：在AppConfig中配置DataSource和SqlSessionFactory
        System.out.println(context.getBean(AppConfig.class));

    }

    public static AbstractApplicationContext getContext() {
        return context;
    }
}
