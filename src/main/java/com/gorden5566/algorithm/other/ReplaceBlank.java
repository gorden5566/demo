package com.gorden5566.algorithm.other;

/**
 * 题目描述
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author gorden5566
 * @date 2019-03-06
 */
public class ReplaceBlank {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int index = 0; index < length; index++) {
            char c = str.charAt(index);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
