package com.gorden5566.learn.pattern.proxy.dynamic.demo;

import com.gorden5566.learn.pattern.proxy.dynamic.demo.proxy.SubjectDynamicProxy;
import com.gorden5566.learn.pattern.proxy.dynamic.demo.target.RealSubject;
import com.gorden5566.learn.pattern.proxy.dynamic.demo.target.Subject;

public class Client2 {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);
        proxy.doSomething("Finish");
    }
}
