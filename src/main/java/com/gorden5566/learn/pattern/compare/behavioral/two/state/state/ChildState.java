package com.gorden5566.learn.pattern.compare.behavioral.two.state.state;

import com.gorden5566.learn.pattern.compare.behavioral.two.state.Human;
import com.gorden5566.learn.pattern.compare.behavioral.two.state.HumanState;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class ChildState extends HumanState {
    @Override
    public void work() {
        System.out.println("儿童的工作是玩耍！");
        super.human.setHumanState(Human.ADULT_STATE);
    }
}
