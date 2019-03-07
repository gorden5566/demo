package com.gorden5566.algorithm.tree;

import com.gorden5566.algorithm.util.TreeNode;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class TreeDepth {
    public static int TreeDepth(TreeNode root) {
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
