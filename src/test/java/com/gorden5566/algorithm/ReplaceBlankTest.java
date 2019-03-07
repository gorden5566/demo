package com.gorden5566.algorithm;

import com.gorden5566.algorithm.other.ReplaceBlank;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2019-03-06
 */
public class ReplaceBlankTest {

    @Test
    public void testReplaceSpace() {
        String str = "We Are Happy";
        String result = ReplaceBlank.replaceSpace(new StringBuffer(str));
        System.out.println(result);
    }
}