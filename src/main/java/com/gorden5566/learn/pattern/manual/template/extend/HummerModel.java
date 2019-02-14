package com.gorden5566.learn.pattern.manual.template.extend;

public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    public void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    /**
     *  Hook Method, 影响了模板方法的执行结果
     *
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }
}
