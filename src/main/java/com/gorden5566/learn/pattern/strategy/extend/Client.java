package com.gorden5566.learn.pattern.strategy.extend;

public class Client {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;

        int result = Calculator.ADD.exec(a, b);
        System.out.println("结果： " + result);
    }
}
