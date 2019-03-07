package com.gorden5566.algorithm.tree;

import com.gorden5566.algorithm.util.TreeNode;

/**
 * 题目描述
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class Mirror {
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        if (left != null) {
            Mirror(left);
        }

        if (right != null) {
            Mirror(right);
        }
    }
}
