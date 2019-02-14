package com.gorden5566.learn.pattern.manual.interpreter.simple.expression.symbol;

import com.gorden5566.learn.pattern.manual.interpreter.simple.expression.Expression;

import java.util.Map;

/**
 * 加号解析器
 *
 * @author gorden5566
 * @date 2019-02-12
 */
public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }


    @Override
    public int interpreter(Map<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
