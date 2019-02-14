package com.gorden5566.learn.pattern.manual.interpreter.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();

        //赋值
        Map<String, Integer> var = getValue(expStr);

        Calculator cal = new Calculator(expStr);

        System.out.println("运算结果为：" + expStr + "=" + cal.run(var));
    }

    /**
     * 获得表达式
     *
     * @return
     * @throws IOException
     */
    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    /**
     * 获得值映射
     *
     * @param exprStr
     * @return
     * @throws IOException
     */
    public static Map<String, Integer> getValue(String exprStr) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        //解析有几个参数要传递
        for (char ch : exprStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                //解决重复参数的问题
                if (!map.containsKey(String.valueOf(ch))) {
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
