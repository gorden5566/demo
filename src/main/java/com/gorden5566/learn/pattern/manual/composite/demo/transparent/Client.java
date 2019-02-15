package com.gorden5566.learn.pattern.manual.composite.demo.transparent;

import com.gorden5566.learn.pattern.manual.composite.demo.transparent.tree.Component;
import com.gorden5566.learn.pattern.manual.composite.demo.transparent.tree.Composite;
import com.gorden5566.learn.pattern.manual.composite.demo.transparent.tree.Leaf;

/**
 * 透明模式
 * 把用来组合使用的方法放到抽象类中，比如add()、remove()以及getChildren等方法
 * 不管叶子对象还是树枝对象都有相同的结构
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

    public static void display(Component root) {
        for (Component child : root.getChildren()) {
            if (child instanceof Leaf) {
                child.doSomething();
            } else {
                display(child);
            }
        }
    }
}
