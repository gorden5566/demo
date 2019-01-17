package com.gorden5566.demos.pattern.reflect;

import org.junit.Test;

public class DynamicProxyTest {

    @Test
    public void test() {
        ITarget target = new Target();
        DynamicProxy dynamicProxy = new DynamicProxy();
        ITarget proxy = (ITarget) dynamicProxy.getProxy(target);
        proxy.doSomeThing();
        proxy.doOtherThing();
    }
}