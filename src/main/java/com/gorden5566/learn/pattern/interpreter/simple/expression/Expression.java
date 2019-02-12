package com.gorden5566.learn.pattern.interpreter.simple.expression;

import java.util.Map;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public abstract class Expression {
    /**
     * 解析公式和数值
     *
     * @param var key值是公式中的参数，value值是具体的数字
     * @return
     */
    public abstract int interpreter(Map<String, Integer> var);
}
