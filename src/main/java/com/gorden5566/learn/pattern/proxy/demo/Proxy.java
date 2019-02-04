package com.gorden5566.learn.pattern.proxy.demo;

public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    private void before() {
        System.out.println("Proxy before");
    }

    private void after() {
        System.out.println("Proxy after");
    }
}
