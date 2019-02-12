package com.gorden5566.learn.pattern.interpreter.simple;

import com.gorden5566.learn.pattern.interpreter.simple.expression.symbol.AddExpression;
import com.gorden5566.learn.pattern.interpreter.simple.expression.Expression;
import com.gorden5566.learn.pattern.interpreter.simple.expression.symbol.SubExpression;
import com.gorden5566.learn.pattern.interpreter.simple.expression.variable.VarExpression;

import java.util.Map;
import java.util.Stack;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Calculator {
    /**
     * 定义表达式
     */
    private Expression expression;

    public Calculator(String expStr) {
        //定义一个栈，安排运算的先后顺序
        Stack<Expression> stack = new Stack<>();

        //表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();

        //运算
        Expression left = null;
        Expression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                //加法
                case '+':
                    //加法结果放到栈中
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                //公式中的变量
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        //把运算结果抛出来
        this.expression = stack.pop();
    }

    /**
     * 开始运算
     *
     * @param var
     * @return
     */
    public int run(Map<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
