package com.gorden5566.framework.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gorden5566
 * @date 2019-03-23
 */
public class TestCircleDependency {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-ioc-config.xml");

        A a = context.getBean(A.class);
        B b = context.getBean(B.class);

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
