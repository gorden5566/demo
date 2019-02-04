package com.gorden5566.learn.pattern.proxy.demo;

public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = new Proxy(subject);
        proxy.request();
    }
}
