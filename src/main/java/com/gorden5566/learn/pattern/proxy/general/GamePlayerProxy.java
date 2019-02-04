package com.gorden5566.learn.pattern.proxy.general;

public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer player;

    public GamePlayerProxy(String name) {
        try {
            player = new GamePlayer(this, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
