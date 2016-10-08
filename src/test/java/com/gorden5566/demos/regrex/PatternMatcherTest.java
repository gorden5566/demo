package com.gorden5566.demos.regrex;

import org.junit.Test;

public class PatternMatcherTest {
    @Test
    public void test() {
        /**
         * 常用非贪婪匹配Pattern
         * 【*?】 重复任意次，但尽可能少重复
         * 【+?】 重复1次或更多次，但尽可能少重复
         * 【??】 重复0次或1次，但尽可能少重复
         * 【{n,m}?】 重复n到m次，但尽可能少重复
         * 【{n,}?】 重复n次以上，但尽可能少重复
         */
        
        String pattern = "((满).*?([0-9]+).*?(减).*?([0-9]+\\.{0,1}[0-9]{0,2})(元))";
        /**
         *  1.小括号表示提取组
         *  2.【.*?】 非提取组，非贪婪匹配，尽可能短的任意字符
         *  3.【([0-9]+)】 提取组，一个以上数字
         *  4. 【([0-9]+\.{0,1}[0-9]{0,2})】 提取组，其中【\\.{0,1}】用于提取小数点
         */
        PatternMatcher patternMatcher = new PatternMatcher(pattern);

        String line = "单个订单满188.00元，立减80.00元";
        patternMatcher.matcher(line);
    }
}