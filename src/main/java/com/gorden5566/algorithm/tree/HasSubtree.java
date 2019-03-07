package com.gorden5566.algorithm.tree;

import com.gorden5566.algorithm.util.TreeNode;

/**
 * 题目描述
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class HasSubtree {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            boolean hasSubTree = isHasSubTree(root1, root2);
            if (hasSubTree) {
                return true;
            }
        }

        if (HasSubtree(root1.left, root2)) {
            return true;
        }

        if (HasSubtree(root1.right, root2)) {
            return true;
        }

        return false;
    }

    public static boolean isHasSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isHasSubTree(root1.left, root2.left) && isHasSubTree(root1.right, root2.right);
    }
}
