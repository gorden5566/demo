package com.gorden5566.framework.spring;

import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public abstract class DefaultConfig {
    protected static AbstractApplicationContext context = TestSpring.getContext();
}
