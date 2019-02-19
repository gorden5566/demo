package com.gorden5566.demos.io;

import org.junit.Test;

import java.io.*;

/**
 * @author gorden5566
 * @date 2019-02-18
 */
public class FileUtilsTest {

    @Test
    public void testCopyFile() throws IOException {
        String path = FileUtilsTest.class.getClassLoader().getResource("").getPath();
        String srcName = path + this.getClass().getSimpleName() + ".txt";

        // 新建一个文件
        FileWriter fileWriter = new FileWriter(new File(srcName));
        fileWriter.write("test test");
        fileWriter.flush();

        // 测试下文件复制
        String targetName = path + "target.txt";
        FileUtils.copyFile(srcName, targetName);
    }

    @Test
    public void testPrintFileContent() throws IOException {
        String path = FileUtilsTest.class.getClassLoader().getResource("").getPath();
        String srcName = path + this.getClass().getSimpleName() + ".txt";

        // 新建一个文件
        FileWriter fileWriter = new FileWriter(new File(srcName));
        fileWriter.write("test test");
        fileWriter.flush();

        FileUtils.printFileContent(srcName);
    }
}