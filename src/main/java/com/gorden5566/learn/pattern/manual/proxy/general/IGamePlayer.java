package com.gorden5566.learn.pattern.manual.proxy.general;

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
}
