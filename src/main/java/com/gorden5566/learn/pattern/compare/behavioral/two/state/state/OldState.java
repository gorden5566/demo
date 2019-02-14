package com.gorden5566.learn.pattern.compare.behavioral.two.state.state;

import com.gorden5566.learn.pattern.compare.behavioral.two.state.HumanState;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class OldState extends HumanState {
    @Override
    public void work() {
        System.out.println("老年人的工作就是享受天伦之乐！");
    }
}
