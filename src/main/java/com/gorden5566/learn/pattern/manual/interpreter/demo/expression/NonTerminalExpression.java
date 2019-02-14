package com.gorden5566.learn.pattern.manual.interpreter.demo.expression;

import com.gorden5566.learn.pattern.manual.interpreter.demo.Context;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class NonTerminalExpression extends Expression {

    /**
     * 每个非终结符表达式都会对其他表达式产生依赖
     *
     * @param expressions
     */
    public NonTerminalExpression(Expression... expressions) {
    }

    @Override
    public Object interpreter(Context context) {
        // 进行文法处理
        return null;
    }
}
