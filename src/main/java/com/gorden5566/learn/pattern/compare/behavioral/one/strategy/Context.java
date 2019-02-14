package com.gorden5566.learn.pattern.compare.behavioral.one.strategy;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Context {

    private Algorithm algorithm;

    public Context(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * 执行压缩算法
     *
     * @param source
     * @param to
     * @return
     */
    public boolean compress(String source,String to){
        return algorithm.compress(source, to);
    }

    /**
     * 执行解压缩算法
     *
     * @param source
     * @param to
     * @return
     */
    public boolean uncompress(String source,String to){
        return algorithm.uncompress(source, to);
    }
}
