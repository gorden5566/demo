package com.gorden5566.framework.spring.config;

import com.gorden5566.framework.spring.DefaultConfig;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class SpringBeanFactoryPostProcessorTest extends DefaultConfig {

    public static void main(String[] args) {
        // 在SpringBeanFactoryPostProcessor中将Before类修改为After类
        System.out.println(context.getBean("before"));
    }
}