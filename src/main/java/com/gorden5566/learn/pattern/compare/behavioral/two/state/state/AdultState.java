package com.gorden5566.learn.pattern.compare.behavioral.two.state.state;

import com.gorden5566.learn.pattern.compare.behavioral.two.state.Human;
import com.gorden5566.learn.pattern.compare.behavioral.two.state.HumanState;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class AdultState extends HumanState {
    @Override
    public void work() {
        System.out.println("成年人的工作就是先养活自己，然后为社会做贡献！");
        super.human.setHumanState(Human.OLD_STATE);
    }
}
