package com.gorden5566.demos.pattern.proxy.cglib;

import com.gorden5566.demos.pattern.proxy.dynamic.BookFacade;
import com.gorden5566.demos.pattern.proxy.dynamic.BookFacadeImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author gorden5566
 * @date 2018/12/25
 */
public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;

        System.out.println("before");
        result = proxy.invokeSuper(obj, args);
        System.out.println("after");

        return result;
    }

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);

        return enhancer.create();
    }

    public static void main(String[] args) {
        BookFacade bookFacade = new BookFacadeImpl();

        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacade proxy = (BookFacade) cglib.getInstance(bookFacade);

        proxy.addBook();
    }
}
