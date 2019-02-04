package com.gorden5566.learn.pattern.proxy.simple;

public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        IGamePlayer proxy = new GamePlayerProxy(player);
        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
