package com.gorden5566.learn.pattern.compare.behavioral.one.command.command;

import com.gorden5566.learn.pattern.compare.behavioral.one.command.AbstractCmd;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class GzipCompressCmd extends AbstractCmd {
    @Override
    public boolean execute(String source, String to) {
        return super.gzip.compress(source, to);
    }
}
