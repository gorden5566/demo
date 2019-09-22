package com.gorden5566.demos.thread.future;

import com.gorden5566.demos.thread.Profiler;

import java.util.concurrent.Callable;

/**
 * @author gorden5566
 * @date 2019/09/19
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException {

        // 定义任务
        // 任务 1 耗时 1s
        // 任务 2 耗时 5s
        Task task1 = new Task("task1", 500);
        Task task2 = new Task("task2", 1000);
        Task task3 = new Task("task3", 678);
        Task task4 = new Task("task4", 50);

        // 开始计时
        Profiler.begin();

        InvokeHelper.submit(task1);
        Future<String> future1 = InvokeHelper.getFuture(String.class);

        InvokeHelper.submit(task2);
        Future<String> future2 = InvokeHelper.getFuture(String.class);

        InvokeHelper.submit(task3);
        Future<String> future3 = InvokeHelper.getFuture(String.class);

        InvokeHelper.submit(task4);
        Future<String> future4 = InvokeHelper.getFuture(String.class);

        String result1 = future1.get(100000);
        String result2 = future2.get(100000);
        String result3 = future3.get(100000);
        String result4 = future4.get(100000);

        // 结束计时
        long cost = Profiler.end();

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

        System.out.println("costMillis: " + cost);
    }

    private static class Task implements Callable<String> {
        private String name;
        private long costMillis;

        public Task(String name, long costMillis) {
            this.name = name;
            this.costMillis = costMillis;
        }

        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(costMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return toString();
        }

        @Override
        public String toString() {
            return "Task{" +
                "name='" + name + '\'' +
                ", costMillis=" + costMillis +
                '}';
        }
    }


}
