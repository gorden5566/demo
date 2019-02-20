package com.gorden5566.demos.io.nio;

import java.nio.ByteBuffer;

/**
 * @author gorden5566
 * @date 2019-02-20
 */
public class TypesInByteBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(30);
        buffer.putLong(7000000000000L);
        buffer.putDouble(Math.PI);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
    }
}
