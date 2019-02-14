package com.gorden5566.learn.pattern.compare.behavioral.one.command.receiver;

import com.gorden5566.learn.pattern.compare.behavioral.one.command.IReceiver;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class GzipReceiver implements IReceiver {
    @Override
    public boolean compress(String source, String to) {
        System.out.println(source + " --> " + to + " GZIP压缩成功!");
        return true;
    }

    @Override
    public boolean uncompress(String source, String to) {
        System.out.println(source + " --> " + to + " GZIP解压缩成功!");
        return true;
    }
}
