package com.gorden5566.framework.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean(AppConfig.class));
    }
}
