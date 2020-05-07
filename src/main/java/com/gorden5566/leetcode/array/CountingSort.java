package com.gorden5566.leetcode.array;

/**
 * @author gorden5566
 * @date 2020/05/07
 */
public class CountingSort {
    /**
     * 计数排序，target是数组，n是数组大小。假设数组中存储的都是非负整数。
     *
     * @param target
     */
    public void countingSort(int[] target) {
        countingSort(target, target.length);
    }

    private void countingSort(int[] target, int n) {
        if (n <= 1) return;

        // 构建辅助数组
        int[] assist = buildAssist(target);

        // 临时数组temp，存储排序之后的结果
        int[] temp = new int[n];

        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            // 待排序元素
            int element = target[i];

            // 找元素的目标位置
            int index = assist[element] - 1;

            // 放入目标位置
            temp[index] = element;

            // 减去一个
            assist[element]--;
        }

        // 将结果拷贝给target数组
        for (int i = 0; i < n; ++i) {
            target[i] = temp[i];
        }
    }

    /**
     * 构建辅助数组，用于存储每个元素的个数分布
     *
     * @param arr
     * @return
     */
    private int[] buildAssist(int[] arr) {
        // 查找数组中数据的范围
        int max = getMax(arr);

        // 申请一个计数数组c，下标大小[0,max]
        int[] assist = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            assist[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int element = arr[i];
            assist[element]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            assist[i] = assist[i - 1] + assist[i];
        }
        return assist;
    }

    /**
     * 获取数组元素的最大值
     *
     * @param arr
     * @return
     */
    private int getMax(int[] arr) {
        int max = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
