package com.gorden5566.learn.pattern.manual.singleton.simple;

public class Minister {

    public static void main(String[] args) {
        for (int day = 0;  day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}
