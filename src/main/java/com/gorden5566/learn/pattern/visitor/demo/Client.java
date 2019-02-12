package com.gorden5566.learn.pattern.visitor.demo;

import com.gorden5566.learn.pattern.visitor.demo.element.Element;
import com.gorden5566.learn.pattern.visitor.demo.visitor.IVisitor;
import com.gorden5566.learn.pattern.visitor.demo.visitor.Visitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        IVisitor visitor = new Visitor();

        for (int i = 0; i < 10; i++) {
            //获得元素对象
            Element element = ObjectStructure.createElement();

            //接受访问者访问
            element.accept(visitor);
        }
    }
}
