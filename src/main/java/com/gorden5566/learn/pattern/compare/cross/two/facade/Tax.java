package com.gorden5566.learn.pattern.compare.cross.two.facade;

import java.util.Random;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Tax {
    /**
     * 收取多少税金
     *
     * @return
     */
    public int getTax(){
        //交纳一个随机数量的税金
        return (new Random()).nextInt(300);
    }
}
