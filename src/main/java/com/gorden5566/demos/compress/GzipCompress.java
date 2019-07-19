package com.gorden5566.demos.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author gorden5566
 * @date 2019/07/17
 */
public class GzipCompress implements Compress {
    @Override
    public byte[] compress(byte[] bytes) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(outputStream);
            gzip.write(bytes);
            gzip.finish();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                gzip.close();
            }
        }
        return outputStream.toByteArray();
    }

    @Override
    public byte[] decompress(byte[] bytes) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        GZIPInputStream gzip = null;
        try {
            gzip = new GZIPInputStream(new ByteArrayInputStream(bytes));

            int count;
            byte[] buffer = new byte[256];

            while ((count = gzip.read(buffer)) != -1) {
                outputStream.write(buffer, 0 , count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                gzip.close();
            }
        }
        return outputStream.toByteArray();
    }
}
