package com.gorden5566.demos.thread.concurrent;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author gorden5566
 * @date 2019/1/9
 */
public class BankWaterService implements Runnable {

    private static int taskCount = 4;

    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(taskCount, this);

    /**
     * 假设只有4个sheet，所以只启动4个线程
     */
    private ExecutorService executor = Executors.newFixedThreadPool(taskCount);

    /**
     * 报错每个sheet计算出的银行流水结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < taskCount; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet的银行流水数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);

                    // 计算完成，插入一个屏障
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executor.shutdown();
    }

    @Override
    public void run() {
        int result = 0;

        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }

        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();

    }
}
