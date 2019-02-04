package com.gorden5566.learn.pattern.proxy.force;

public class GamePlayer implements IGamePlayer {

    private String name;

    /**
     * 必须设置这个代理才能访问
     */
    private IGamePlayer proxy;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String user, String password) {
        if (this.isProxy()) {
            System.out.println("登录名为[" + user + "]的用户[" + this.name + "]登录成功！");
        } else {
            System.out.println("请使用指定的代理访问！");
        }
    }

    @Override
    public void killBoss() {
        if (this.isProxy()) {
            System.out.println(this.name + "在打怪！ ");
        } else {
            System.out.println("请使用指定的代理访问！");
        }
    }

    /**
     * 当前是否通过代理访问
     *
     * @return
     */
    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        }
        return true;
    }

    @Override
    public void upgrade() {
        if (this.isProxy()) {
            System.out.println(this.name + "又升了一级！ ");
        } else {
            System.out.println("请使用指定的代理访问！");
        }
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }
}
