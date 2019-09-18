package com.gorden5566.demos.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gorden5566
 * @date 2019/09/19
 */
public class FutureTaskTest {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {

        // 定义任务
        // 任务 1 耗时 1s
        // 任务 2 耗时 5s
        FutureTask<String> future1 = new FutureTask<>(new Task("task1", 1));
        FutureTask<String> future2 = new FutureTask<>(new Task("task2", 5));

        long start = System.currentTimeMillis();

        threadPool.submit(future1);
        threadPool.submit(future2);

        String task1 = future1.get(100000);
        String task2 = future2.get(100000);

        long end = System.currentTimeMillis();

        System.out.println(task1);
        System.out.println(task2);

        System.out.println("cost: " + (end - start));
    }

    private static class Task implements Callable<String> {
        private String name;
        private int count;

        public Task(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(count * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return toString();
        }

        @Override
        public String toString() {
            return "Task{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
        }
    }


}
