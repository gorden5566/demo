package com.gorden5566.learn.pattern.compare.cross.wrapper.proxy;

import com.gorden5566.learn.pattern.compare.cross.wrapper.proxy.proxy.Agent;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Idolater {
    public static void main(String[] args) {
        //崇拜的明星是谁
        IStar star = new Singer();
        //找到明星的经纪人
        IStar agent = new Agent(star);
        System.out.println("追星族：我是你的崇拜者，请签名！");
        //签字
        agent.sign();
    }
}
