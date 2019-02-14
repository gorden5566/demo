package com.gorden5566.learn.pattern.compare.behavioral.one.strategy;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public interface Algorithm {
    /**
     * 压缩算法
     *
     * @param source
     * @param to
     * @return
     */
    boolean compress(String source,String to);

    /**
     * 解压缩算法
     * @param source
     * @param to
     * @return
     */
    boolean uncompress(String source,String to);
}
