package com.gorden5566.demos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *
 * @author gorden5566
 * @date 2016/9/18
 */
public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    private static final String CHARSET = "UTF-8";

    public static String encodeUrl(String str) {
        String encodeStr = null;
        try {
            encodeStr = URLEncoder.encode(str, CHARSET);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return encodeStr;
    }

    public static String decodeUrl(String encodeStr) {
        String str = null;
        try {
            str = URLDecoder.decode(encodeStr, CHARSET);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return str;
    }

    public static String getPackagePath(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        return clazz.getResource("").getPath();
    }

    public static String getPackageRootPath(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        return clazz.getResource("/").getPath();
    }
}
