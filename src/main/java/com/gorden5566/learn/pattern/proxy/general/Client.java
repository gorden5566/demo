package com.gorden5566.learn.pattern.proxy.general;

public class Client {
    public static void main(String[] args) {
        IGamePlayer proxy = new GamePlayerProxy("张三");
        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
