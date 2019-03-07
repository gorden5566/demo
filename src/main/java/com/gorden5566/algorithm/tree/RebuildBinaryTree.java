package com.gorden5566.algorithm.tree;

import com.gorden5566.algorithm.util.TreeNode;

/**
 * 题目描述
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author gorden5566
 * @date 2019-03-06
 */
public class RebuildBinaryTree {

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }

        return doConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode doConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        // 根节点
        TreeNode root = new TreeNode(pre[startPre]);

        TreeNode leftNode = null;
        TreeNode rightNode = null;
        for (int index = startIn; index <= endIn; index++) {
            // 找到中序的根节点
            if (in[index] == pre[startPre]) {
                // 根据中序划分，得到左子树和右子树节点个数
                int leftNum = index - startIn;
                int rightNum = endIn - index;

                leftNode = doConstructBinaryTree(pre, startPre + 1, startPre + leftNum, in, startIn, index - 1);
                rightNode = doConstructBinaryTree(pre, startPre + leftNum + 1, endPre, in, index + 1, endIn);
                break;
            }
        }

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
