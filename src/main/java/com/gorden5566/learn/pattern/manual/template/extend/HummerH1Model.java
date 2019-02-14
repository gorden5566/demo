package com.gorden5566.learn.pattern.manual.template.extend;

public class HummerH1Model extends HummerModel {

    private boolean alarmFlag = true;

    @Override
    public void start() {
        System.out.println("悍马H1发动...");
    }

    @Override
    public void stop() {
        System.out.println("悍马H1停车...");
    }

    @Override
    public void alarm() {
        System.out.println("悍马H1鸣笛...");

    }

    @Override
    public void engineBoom() {
        System.out.println("悍马H1引擎声音...");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarmFlag(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}
