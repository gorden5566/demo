package com.gorden5566.learn.pattern.template.simple;

public abstract class HummerModel {

    public abstract void start();

    public abstract void stop();

    public abstract void alarm();

    public abstract void engineBoom();

    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
