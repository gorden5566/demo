package com.gorden5566.demos.io;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2019-02-19
 */
public class NIOUtilsTest {

    @Test
    public void testCopy() throws IOException {
        String path = FileUtilsTest.class.getClassLoader().getResource("").getPath();
        String srcName = path + this.getClass().getSimpleName() + ".txt";

        // 新建一个文件
        FileWriter fileWriter = new FileWriter(new File(srcName));
        fileWriter.write("test test");
        fileWriter.flush();

        // 测试下文件复制
        String targetName = path + "target.txt";
        NIOUtils.copy(srcName, targetName);
    }
}