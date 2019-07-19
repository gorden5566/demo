package com.gorden5566.demos.compress;

import java.io.IOException;

/**
 * @author gorden5566
 * @date 2019/07/18
 */
public class CompressTest {
    public static void main(String[] args) throws IOException {
        byte[] data = generateTestData();

        Compress gzip = new GzipCompress();
        Compress snappy = new SnappyCompress();

        test1(gzip, data);
        test1(snappy, data);

        test2(gzip, data);
        test2(snappy, data);
    }

    private static void test1(Compress compress, byte[] data) throws IOException {
        System.out.println(compress.getClass());

        byte[] temp = compress.compress(data);
        System.out.println("after compress: " + temp.length);

        byte[] result = compress.decompress(temp);
        System.out.println("after decompress: " + result.length);

        System.out.println();
    }

    private static void test2(Compress compress, byte[] data) throws IOException {
        System.out.println(compress.getClass());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            compress.compress(data);
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("cost(ms): " + cost);

        System.out.println();
    }

    private static byte[] generateTestData() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 26; j++) {
                sb.append((char) ('a' + j));
            }
            for (int j = 0; j < 26; j++) {
                sb.append((char) ('A' + j));
            }
        }
        String result = sb.toString();
        return result.getBytes();
    }
}
