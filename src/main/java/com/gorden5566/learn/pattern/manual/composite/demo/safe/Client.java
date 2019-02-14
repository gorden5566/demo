package com.gorden5566.learn.pattern.manual.composite.demo.safe;

import com.gorden5566.learn.pattern.manual.composite.demo.safe.tree.Component;
import com.gorden5566.learn.pattern.manual.composite.demo.safe.tree.Composite;
import com.gorden5566.learn.pattern.manual.composite.demo.safe.tree.Leaf;

/**
 * 安全模式
 */
public class Client {
    public static void main(String[] args) {
        //创建一个根节点
        Composite root = new Composite();
        root.doSomething();

        //创建一个树枝构件
        Composite branch = new Composite();

        //创建一个叶子节点
        Leaf leaf = new Leaf();

        //建立整体
        root.add(branch);
        branch.add(leaf);

        // 显示节点
        display(root);
    }

    /**
     * 通过递归遍历树
     *
     * @param root
     */
    public static void display(Composite root) {
        for (Component c : root.getChildren()) {
            if (c instanceof Leaf) { //叶子节点
                c.doSomething();
            } else { //树枝节点
                display((Composite) c);
            }
        }
    }
}
