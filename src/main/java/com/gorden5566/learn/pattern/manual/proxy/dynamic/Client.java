package com.gorden5566.learn.pattern.manual.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");

        InvocationHandler handler = new GamePlayIH(player);

        ClassLoader classLoader = player.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, handler);


        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
