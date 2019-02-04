package com.gorden5566.learn.pattern.proxy.force;

public class Client {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    /**
     * 直接访问，不行
     */
    private static void test1() {
        IGamePlayer player = new GamePlayer("张三");
        player.login("zhangsan", "password");
        player.killBoss();
        player.upgrade();
    }

    /**
     * 直接创建代理访问，也不行
     */
    private static void test2() {
        IGamePlayer player = new GamePlayer("张三");
        IGamePlayer proxy = new GamePlayerProxy(player);
        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
    }

    /**
     * 必须通过真实对象获取对应代理进行访问
     */
    private static void test3() {
        IGamePlayer player = new GamePlayer("张三");
        IGamePlayer proxy = player.getProxy();
        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
