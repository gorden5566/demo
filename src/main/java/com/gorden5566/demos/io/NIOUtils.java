package com.gorden5566.demos.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author gorden5566
 * @date 2019-02-19
 */
public class NIOUtils {
    public static void copy(String src, String target) throws IOException {
        // 获取输入字节流
        FileInputStream fileInputStream = new FileInputStream(src);

        // 获取输入文件通道
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        // 获取输出字节流
        FileOutputStream fileOutputStream = new FileOutputStream(target);

        // 获取输出文件通道
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        // 缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            // 读取数据到缓冲区
            int read = inputStreamChannel.read(byteBuffer);

            // -1 表示 EOF
            if (read == -1) {
                break;
            }

            // 切换读写
            byteBuffer.flip();

            outputStreamChannel.write(byteBuffer);

            // 清空缓冲区
            byteBuffer.clear();
        }
    }
}
