package com.gorden5566.learn.pattern.compare.behavioral.one.command.receiverTwo;

import com.gorden5566.learn.pattern.compare.behavioral.one.command.IReceiverTwo;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class CompressReceiver implements IReceiverTwo {
    @Override
    public boolean zipExec(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP压缩成功!");
        return true;
    }

    @Override
    public boolean gzipExec(String source, String to) {
        System.out.println(source + " --> " + to + " GZIP压缩成功!");
        return true;
    }
}
