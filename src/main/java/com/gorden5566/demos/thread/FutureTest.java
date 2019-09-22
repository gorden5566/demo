package com.gorden5566.demos.thread;

import java.util.concurrent.*;

/**
 * @author gorden5566
 * @date 2019/09/18
 */
public class FutureTest implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> submit = executorService.submit(new FutureTest());

        String s = submit.get();
        System.out.println(s);
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(100000);
        return "Hello";
    }
}
