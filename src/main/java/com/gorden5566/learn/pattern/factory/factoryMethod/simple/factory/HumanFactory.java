package com.gorden5566.learn.pattern.factory.factoryMethod.simple.factory;

import com.gorden5566.learn.pattern.factory.human.Human;

/**
 * 通过工厂的实例进行调用
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) human;
    }
}
