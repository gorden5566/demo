package com.gorden5566.algorithm.tree;

import com.gorden5566.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class KthNode {

    private int index;

    public TreeNode kthNode(TreeNode pRoot, int k) {
        index = 0;
        return doTraverse(pRoot, k);
    }

    private TreeNode doTraverse(TreeNode node, int k) {
        if (node == null || k <= 0) {
            return null;
        }

        // 遍历左子树
        TreeNode left = doTraverse(node.left, k);
        if (left != null) {
            return left;
        }

        // 根节点
        index++;
        if (index == k) {
            return node;
        }

        // 遍历右子树
        TreeNode right = doTraverse(node.right, k);
        if (right != null) {
            return right;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode node = initTestTree();

        KthNode kthNode = new KthNode();
        TreeNode result = kthNode.kthNode(node, 3);

        System.out.println(result.val);
    }

    public static TreeNode initTestTree() {
        int[] array = {5, 3, 7, 2, 4, 6, 8};

        List<TreeNode> nodeList = new ArrayList<>(array.length);
        for (int val : array) {
            nodeList.add(new TreeNode(val));
        }

        int current = 0;
        int left = 1;
        int right = 2;
        while (right < array.length) {
            TreeNode node = nodeList.get(current);
            TreeNode leftNode = nodeList.get(left);
            TreeNode rightNode = nodeList.get(right);

            node.left = leftNode;
            node.right = rightNode;

            current++;
            left += 2;
            right += 2;
        }

        return nodeList.get(1);
    }
}
