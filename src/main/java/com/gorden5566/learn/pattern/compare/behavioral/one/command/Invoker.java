package com.gorden5566.learn.pattern.compare.behavioral.one.command;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Invoker {
    /**
     * 抽象命令的引用
     */
    private AbstractCmd cmd;

    public Invoker(AbstractCmd cmd) {
        this.cmd = cmd;
    }

    /**
     * 执行命令
     *
     * @param source
     * @param to
     * @return
     */
    public boolean execute(String source, String to) {
        return cmd.execute(source, to);
    }
}
