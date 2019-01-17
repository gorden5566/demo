package com.gorden5566.framework.spring.bean;

/**
 * 一个简单的 bean
 * @author gorden5566
 * @date 2019/1/17
 */
public class SpringBean {

    public SpringBean() {
        System.out.println("SpringBean construct--------");
    }

    @Override
    public String toString() {
        return "SpringBean{}";
    }
}
