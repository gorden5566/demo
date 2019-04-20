package com.gorden5566.framework.spring.placeholder;

import com.gorden5566.framework.spring.placeholder.bean.MyEnvironment;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gorden5566
 * @date 2019/04/20
 */
public class TestPlaceholder {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("placeholder/application-test.xml");
        MyEnvironment environment = context.getBean("environment", MyEnvironment.class);
        System.out.println(environment);
    }
}
