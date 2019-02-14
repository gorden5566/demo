package com.gorden5566.learn.pattern.manual.strategy.demo;

import com.gorden5566.learn.pattern.manual.strategy.demo.strategy.ConcreteStrategy1;
import com.gorden5566.learn.pattern.manual.strategy.demo.strategy.ConcreteStrategy2;
import com.gorden5566.learn.pattern.manual.strategy.demo.strategy.Strategy;

public class Client {
    public static void main(String[] args) {
        Strategy strategy1 = new ConcreteStrategy1();
        Strategy strategy2 = new ConcreteStrategy2();

        Context context = new Context(strategy1);
        context.doAnything();

        context.setStrategy(strategy2);
        context.doAnything();
    }
}
