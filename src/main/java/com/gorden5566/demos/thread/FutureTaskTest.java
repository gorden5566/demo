package com.gorden5566.demos.thread;

import java.util.concurrent.*;

/**
 * @author gorden5566
 * @date 2019/1/10
 */
public class FutureTaskTest implements Runnable {
    private final ConcurrentHashMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    private String taskName;

    public FutureTaskTest(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 执行任务并获取结果，每个任务最多执行一次
     *
     * @param taskName
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName);
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };

                // 创建任务
                FutureTask<String> futureTask = new FutureTask<>(task);

                // key不存在时返回 null，否则返回原值
                future = taskCache.putIfAbsent(taskName, futureTask);

                // 确保只会执行一次
                if (future == null) {
                    future = futureTask;

                    // 执行任务
                    System.out.println("task run, taskName: " + taskName);
                    futureTask.run();
                }

                try {
                    return future.get();
                } catch (CancellationException e) {
                    taskCache.remove(taskName, future);
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            String result = executionTask(taskName);
            System.out.println(Thread.currentThread().getName() + ", result: " + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FutureTaskTest test = new FutureTaskTest("task1");

        new Thread(test, "Thread-1").start();
        new Thread(test, "Thread-2").start();
        new Thread(test, "Thread-3").start();
    }
}
