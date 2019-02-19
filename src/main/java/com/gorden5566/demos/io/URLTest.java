package com.gorden5566.demos.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author gorden5566
 * @date 2019-02-19
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");

        InputStream inputStream = url.openStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
