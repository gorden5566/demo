package com.gorden5566.learn.pattern.compare.behavioral.one.command;

import com.gorden5566.learn.pattern.compare.behavioral.one.command.receiver.GzipReceiver;
import com.gorden5566.learn.pattern.compare.behavioral.one.command.receiver.ZipReceiver;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class AbstractCmd {
    /**
     * 对接收者的引用
     */
    protected IReceiver zip = new ZipReceiver();
    protected IReceiver gzip = new GzipReceiver();

    /**
     * 抽象方法，命令的具体单元
     *
     * @param source
     * @param to
     * @return
     */
    public abstract boolean execute(String source, String to);
}
