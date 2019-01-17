package com.gorden5566.framework.spring.factorybean;

import com.gorden5566.framework.spring.DefaultConfig;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class SpringFactoryBeanTest extends DefaultConfig {

    public static void main(String[] args) {
        // 打印SpringBean的实例
        System.out.println("SpringBean: " + context.getBean("springFactoryBean"));

        // 打印SpringFactoryBean的实例
        System.out.println("SpringFactoryBean: " + context.getBean("&springFactoryBean"));
    }
}