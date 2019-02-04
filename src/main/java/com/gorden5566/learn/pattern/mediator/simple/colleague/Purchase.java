package com.gorden5566.learn.pattern.mediator.simple.colleague;

import com.gorden5566.learn.pattern.mediator.simple.mediator.AbstractMediator;

public class Purchase extends AbstractColleague {
    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    /**
     * 采购IBM电脑
     *
     * @param number
     */
    public void buyIBMcomputer(int number) {
        super.mediator.execute("purchase.buy", number);
    }

    //不再采购IBM电脑
    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }
}
