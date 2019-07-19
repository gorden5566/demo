package com.gorden5566.demos.compress;

import java.io.IOException;

/**
 * @author gorden5566
 * @date 2019/07/18
 */
public interface Compress {
    /**
     * 压缩
     *
     * @param bytes
     * @return
     * @throws IOException
     */
    byte[] compress(byte[] bytes) throws IOException;

    /**
     * 解压缩
     *
     * @param bytes
     * @return
     * @throws IOException
     */
    byte[] decompress(byte[] bytes) throws IOException;
}
