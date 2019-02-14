package com.gorden5566.learn.pattern.manual.proxy.force;

public class GamePlayerProxy implements IGamePlayer {

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
    }

    @Override
    public IGamePlayer getProxy() {
        // 代理的代理暂时还没有， 就是自己
        return this;
    }
}
