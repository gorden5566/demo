package com.gorden5566.learn.pattern.compare.behavioral.one.command;

import com.gorden5566.learn.pattern.compare.behavioral.one.command.command.ZipCompressCmd;
import com.gorden5566.learn.pattern.compare.behavioral.one.command.command.ZipUncompressCmd;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //定义一个命令,压缩一个文件
        AbstractCmd cmd = new ZipCompressCmd();
//        AbstractCmd cmd = new ZipUncompressCmd();

        //定义调用者
        Invoker invoker = new Invoker(cmd);
        //我命令你对这个文件进行压缩
        System.out.println("========执行压缩命令========");
        invoker.execute("c:\\windows", "d:\\windows.zip");
    }
}
