package com.gorden5566.demos.thread.state;

/**
 * @author gorden5566
 * @date 2019-02-21
 */
public class StateNew {
    public static void main(String[] args) {
        // 创建线程对象
        Thread thread = new Thread("myThread");

        // 输出线程状态
        System.out.println(thread.getName() + ": " + thread.getState());

        // 启动线程
        thread.start();
    }
}

