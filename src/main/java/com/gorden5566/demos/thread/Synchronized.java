package com.gorden5566.demos.thread;

/**
 * @author gorden5566
 * @date 2018/9/1
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }

        m();
    }
    public static synchronized void m() {
    }
}
