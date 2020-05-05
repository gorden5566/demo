package com.gorden5566.demos.thread;

/**
 * @author gorden5566
 * @date 2019/12/20
 */
public class ThreadUtil {
    /**
     * 打印当前位置的调用栈信息
     *
     * @param msg
     */
    public static void printStackTrace(String msg) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        println(Thread.currentThread() + ", message: [" + msg + "]");
        if (stackTrace == null || stackTrace.length < 2) {
            println("empty stack");
            return;
        }

        for (int i = 2; i < stackTrace.length; i++) {
            println("\tat " + stackTrace[i]);
        }
    }

    private static void println(Object object) {
        System.out.println(object);
    }
}
