package com.gorden5566.learn.pattern.compare.behavioral.one.command;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public interface IReceiver {
    /**
     * 压缩
     *
     * @param source
     * @param to
     * @return
     */
    boolean compress(String source, String to);

    /**
     * 解压缩
     *
     * @param source
     * @param to
     * @return
     */
    boolean uncompress(String source, String to);
}
