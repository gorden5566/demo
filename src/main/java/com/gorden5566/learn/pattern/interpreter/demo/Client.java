package com.gorden5566.learn.pattern.interpreter.demo;

import com.gorden5566.learn.pattern.interpreter.demo.expression.Expression;

import java.util.Stack;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        Stack<Expression> stack = null;

        //进行语法判断，并产生递归调用

        Expression expression = stack.pop();
        //具体元素进入场景
        expression.interpreter(context);
    }
}
