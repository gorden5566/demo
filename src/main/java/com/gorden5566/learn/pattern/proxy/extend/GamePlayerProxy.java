package com.gorden5566.learn.pattern.proxy.extend;

public class GamePlayerProxy implements IGamePlayer, IProxy {

    private IGamePlayer player;

    public GamePlayerProxy(IGamePlayer player) {
        this.player = player;
    }

    @Override
    public void login(String user, String password) {
        this.player.login(user, password);
    }

    @Override
    public void killBoss() {
        this.player.killBoss();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
        this.count();
    }

    @Override
    public void count() {
        System.out.println("升级总费用是： 150元");
    }
}
