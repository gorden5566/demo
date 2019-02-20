package com.gorden5566.demos.io.nio;

import java.nio.ByteBuffer;

/**
 * @author gorden5566
 * @date 2019-02-20
 */
public class SliceBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        // slice 分割
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();

        // 修改 slice 内容
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b *= 11;
            slice.put(b);
        }

        // 重置
        buffer.position(0);
        buffer.limit(buffer.capacity());

        // 输出
        while (buffer.remaining() > 0) {
            System.out.println(buffer.get());
        }
    }
}
