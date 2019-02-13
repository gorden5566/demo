package com.gorden5566.learn.pattern.bridge.simple.corp;

import com.gorden5566.learn.pattern.bridge.simple.product.House;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class HouseCorp extends Corp {

    public HouseCorp(House house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}
