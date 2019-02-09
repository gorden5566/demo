package com.gorden5566.learn.pattern.composite.demo.tree;

/**
 * 叶子组件
 */
public class Leaf extends Component {
    @Override
    public void doSomething() {
        System.out.println("Leaf doSomething");
    }
}
