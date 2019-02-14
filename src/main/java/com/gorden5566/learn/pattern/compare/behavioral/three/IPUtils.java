package com.gorden5566.learn.pattern.compare.behavioral.three;

import java.util.Random;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class IPUtils {
    /**
     * 随机产生一个IP地址，工具类，现实中不会这么用
     *
     * @return
     */
    public static String genIpAddress() {
        Random rand = new Random();
        String address = rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255);
        return address;
    }
}
