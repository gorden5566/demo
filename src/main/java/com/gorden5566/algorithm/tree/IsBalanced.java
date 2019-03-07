package com.gorden5566.algorithm.tree;

import com.gorden5566.algorithm.util.TreeNode;

/**
 * 题目描述
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class IsBalanced {
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static boolean IsBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getBalancedDepth(root) != -1;
    }

    private static int getBalancedDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = getBalancedDepth(node.left);
        int rightDepth = getBalancedDepth(node.right);

        if (leftDepth == -1) {
            return -1;
        }

        if (rightDepth == -1) {
            return -1;
        }

        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return -1;
        }

        int childDepth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return childDepth + 1;
    }

    private static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = TreeDepth(root.left);
        }

        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = TreeDepth(root.right);
        }

        int childDepth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return childDepth + 1;
    }
}
