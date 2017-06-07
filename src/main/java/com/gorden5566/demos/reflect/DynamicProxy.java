package com.gorden5566.demos.reflect;

import java.lang.reflect.Proxy;

public class DynamicProxy {
    public Object getProxy(Object object) {
        ProxyHandler proxyHandler = new ProxyHandler();
        proxyHandler.setObject(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), proxyHandler);
    }
}
