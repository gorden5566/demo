package com.gorden5566.algorithm.tree;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class VerifySquenceOfBST {
    public boolean VerifySequenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return doVerifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean doVerifySequenceOfBST(int[] sequence, int start, int end) {
        int root = sequence[end];

        // 找到左子树
        int index = start;
        while (sequence[index] < root) {
            index++;
        }

        // 检查右子树
        for (int i = index; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        boolean checkLeft = true;
        if (index > start) {
            checkLeft = doVerifySequenceOfBST(sequence, start, index - 1);
        }

        boolean checkRight = true;
        if (index < end) {
            checkRight = doVerifySequenceOfBST(sequence, index, end - 1);
        }

        return checkLeft && checkRight;
    }
}
