package com.gorden5566.learn.pattern.interpreter.demo.expression;

import com.gorden5566.learn.pattern.interpreter.demo.Context;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public abstract class Expression {

    /**
     * 每个表达式必须有一个解析任务
     *
     * @param context
     * @return
     */
    public abstract Object interpreter(Context context);
}
