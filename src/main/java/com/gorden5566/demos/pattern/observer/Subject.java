package com.gorden5566.demos.pattern.observer;

public interface Subject {
    /**
     * 添加观察者
     * @param observer
     */
    public void attach(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * 通知观察者
     * @param info
     */
    public void notify(String info);
}
