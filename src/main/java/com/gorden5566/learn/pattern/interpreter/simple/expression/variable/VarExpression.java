package com.gorden5566.learn.pattern.interpreter.simple.expression.variable;

import com.gorden5566.learn.pattern.interpreter.simple.expression.Expression;

import java.util.Map;

/**
 * 变量解析器
 *
 * @author gorden5566
 * @date 2019-02-12
 */
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(Map<String, Integer> var) {
        return var.get(this.key);
    }
}
