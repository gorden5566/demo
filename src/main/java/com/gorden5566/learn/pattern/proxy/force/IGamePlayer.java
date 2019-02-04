package com.gorden5566.learn.pattern.proxy.force;

public interface IGamePlayer {

    /**
     * 登录游戏
     *
     * @param user
     * @param password
     */
    void login(String user, String password);

    /**
     * 杀怪
     */
    void killBoss();

    /**
     * 升级
     */
    void upgrade();

    /**
     * 通过真实角色找到自己的代理
     *
     * @return
     */
    IGamePlayer getProxy();
}
