package com.gorden5566.learn.pattern.manual.interpreter.simple.expression.symbol;

import com.gorden5566.learn.pattern.manual.interpreter.simple.expression.Expression;

/**
 * 符号解析器
 *
 * @author gorden5566
 * @date 2019-02-12
 */
public abstract class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
