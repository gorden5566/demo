package com.gorden5566.learn.pattern.compare.behavioral.one.command;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public interface IReceiverTwo {
    /**
     * 执行zip命令
     *
     * @param source
     * @param to
     * @return
     */
    boolean zipExec(String source, String to);

    /**
     * 执行gzip命令
     *
     * @param source
     * @param to
     * @return
     */
    boolean gzipExec(String source, String to);
}
