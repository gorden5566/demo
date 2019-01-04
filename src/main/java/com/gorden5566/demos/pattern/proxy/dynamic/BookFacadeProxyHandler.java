package com.gorden5566.demos.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gorden5566
 * @date 2018/12/25
 */
public class BookFacadeProxyHandler implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("before");
        result = method.invoke(target, args);
        System.out.println("after");
        return result;
    }

    public Object bind(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        BookFacade bookFacade = new BookFacadeImpl();

        BookFacadeProxyHandler proxyHandler = new BookFacadeProxyHandler();
        BookFacade proxy = (BookFacade) proxyHandler.bind(bookFacade);

//        proxy.addBook();

        BookFacade proxy1 = (BookFacade) Proxy.newProxyInstance(bookFacade.getClass().getClassLoader(), bookFacade.getClass().getInterfaces(), proxyHandler);
        proxy1.addBook();

    }
}
