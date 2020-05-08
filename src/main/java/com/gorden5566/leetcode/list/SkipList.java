package com.gorden5566.leetcode.list;

/**
 * @author gorden5566
 * @date 2020/05/08
 */
public class SkipList {
    private static final double LEVEL_PROB = 0.5d;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;
    private Node head = new Node();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            // 按层往后找到前驱节点（比目标值小的最大节点）
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }

            // 继续往下一层找
        }

        // 找到节点
        if (p.next[0] != null && p.next[0].data == value) {
            return p;
        }
        return null;
    }

    public void insert(int value) {
        int level = randomLevel();

        // 新节点
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;

        // 记录每一层的前驱节点
        Node[] update = new Node[level];
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            // 按层往后找到前驱节点（比目标值小的最大节点）
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
            // 记录前驱节点
            update[i] = p;
        }

        // 插入节点
        for (int i = level - 1; i >= 0; i--) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }

        // 更新levelCount
        if (levelCount < level) {
            levelCount = level;
        }
    }

    /**
     * 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     * 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
     * 随机生成 1~MAX_LEVEL 之间的数，且 ：
     *      50%的概率返回    1
     *      25%的概率返回    2
     *      12.5%的概率返回  3
     *      ......
     * @return
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < LEVEL_PROB && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public void delete(int value) {
        // 记录每一层的前驱节点
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            // 按层往后找到前驱节点（比目标值小的最大节点）
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
            // 记录前驱节点
            update[i] = p;
        }

        // 找到了
        if (p.next[0] != null && p.next[0].data == value) {
            // 按层删除
            for (int i = levelCount - 1; i >= 0; i--) {
                if (update[i].next[i] != null && update[i].next[i].data == value) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }

        // 更新levelCount
        while (levelCount > 1 && head.next[levelCount] == null) {
            levelCount--;
        }
    }

    public class Node {
        private int data = -1;
        private Node[] next = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}
