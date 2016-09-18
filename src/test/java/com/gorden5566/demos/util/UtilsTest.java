package com.gorden5566.demos.util;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void test() {
        String str = "ASUS华硕";

        String encodeStr = Utils.encodeUrl(str);
        System.out.println(encodeStr);

        String decodeStr = Utils.decodeUrl(encodeStr);
        System.out.println(decodeStr);
    }
}