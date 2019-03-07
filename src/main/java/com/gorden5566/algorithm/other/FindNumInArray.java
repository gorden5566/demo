package com.gorden5566.algorithm.other;

/**
 * 题目描述：
 *
 * 在一个二维数组中（每个一维数组的长度相同）
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author gorden5566
 * @date 2019-03-06
 */
public class FindNumInArray {
    public static boolean find(int target, int[][] array) {
        // 参数检查
        if (array == null || array.length <= 0 || array[0].length < 0) {
            return false;
        }

        // 行数和列数
        final int rows = array.length;
        final int cols = array[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            // 找到数据
            if (array[row][col] == target) {
                return true;
            }
            // 目标在下边
            else if (array[row][col] < target) {
                row++;
            }
            // 目标在左边
            else if (array[row][col] > target) {
                col--;
            }
        }

        return false;
    }
}
