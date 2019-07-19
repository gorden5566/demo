package com.gorden5566.demos.compress;

import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * @author gorden5566
 * @date 2019/07/18
 */
public class SnappyCompress implements Compress {
    @Override
    public byte[] compress(byte[] bytes) throws IOException {
        if (bytes == null) {
            return null;
        }
        return Snappy.compress(bytes);
    }

    @Override
    public byte[] decompress(byte[] bytes) throws IOException {
        if (bytes == null) {
            return null;
        }
        return Snappy.uncompress(bytes);
    }
}
