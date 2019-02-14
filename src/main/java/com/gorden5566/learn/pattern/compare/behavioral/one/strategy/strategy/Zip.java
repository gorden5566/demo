package com.gorden5566.learn.pattern.compare.behavioral.one.strategy.strategy;

import com.gorden5566.learn.pattern.compare.behavioral.one.strategy.Algorithm;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Zip implements Algorithm {
    @Override
    public boolean compress(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP压缩成功!");
        return true;
    }

    @Override
    public boolean uncompress(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP解压缩成功!");
        return true;
    }
}
