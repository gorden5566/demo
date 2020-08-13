package com.gorden5566.demos.guice;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author gorden5566
 * @date 2020/07/02
 */
public class HttpUtils {
    static {
        System.out.println("class init");
    }

    public HttpUtils() {
        System.out.println("constructor");
    }

    public String doGet(String url) {

        InputStreamReader isr = null;
        InputStreamReader esr = null;
        int statusCode;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(100);

            connection.connect();

            statusCode = connection.getResponseCode();
            String response;

            try {
                isr = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                response = CharStreams.toString(isr);
            } catch (IOException e) {
                esr = new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8);
                response = CharStreams.toString(esr);
            }

            return response;
        } catch (IOException e) {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException ex) {
                    //
                }

                if (esr != null) {
                    try {
                        esr.close();
                    } catch (IOException ex) {
                        //
                    }
                }
            }

        }

        return null;
    }

    public static void main(String[] args) {
        HttpUtils httpUtils = new HttpUtils();
        String request = httpUtils.doGet("https://www.baidu.com");
        System.out.println(request);
    }
}
