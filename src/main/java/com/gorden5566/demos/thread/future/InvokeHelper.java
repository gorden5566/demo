package com.gorden5566.demos.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gorden5566
 * @date 2019/09/19
 */
public class InvokeHelper {

    private static ThreadLocal<Future> futureThreadLocal = new ThreadLocal<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void submit(Callable task) {
        FutureTask futureTask = new FutureTask<>(task);

        threadPool.submit(futureTask);

        futureThreadLocal.set(futureTask);
    }

    public static <T> Future<T> getFuture(Class<T> clazz) {
        return (Future<T>) getFuture();
    }

    public static Future getFuture() {
        Future future = futureThreadLocal.get();
        futureThreadLocal.remove();
        return future;
    }
}
