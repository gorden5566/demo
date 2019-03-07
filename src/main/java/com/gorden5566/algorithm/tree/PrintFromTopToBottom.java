package com.gorden5566.algorithm.tree;

import com.gorden5566.algorithm.util.TreeNode;

import java.util.ArrayList;

/**
 * 题目描述
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            result.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }
}
