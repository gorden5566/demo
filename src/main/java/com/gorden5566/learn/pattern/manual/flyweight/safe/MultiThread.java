package com.gorden5566.learn.pattern.manual.flyweight.safe;

import com.gorden5566.learn.pattern.manual.flyweight.simple.SignInfo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class MultiThread extends Thread {

    private SignInfo signInfo;

    public MultiThread(SignInfo signInfo) {
        this.signInfo = signInfo;
    }

    @Override
    public void run() {
        if (!signInfo.getId().equals(signInfo.getLocation())) {
            System.out.println("编号：" + signInfo.getId());
            System.out.println("考试地址：" + signInfo.getLocation());
            System.out.println("线程不安全了！");
        }
    }
}
