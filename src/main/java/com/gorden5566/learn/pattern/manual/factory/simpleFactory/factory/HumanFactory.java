package com.gorden5566.learn.pattern.manual.factory.simpleFactory.factory;

import com.gorden5566.learn.pattern.manual.factory.common.base.Human;

public class HumanFactory {
    /**
     * 根据类型生成对应实例
     * 与工厂方法不同, 这里是静态方法
     *
     * @param c
     * @param <T>
     * @return
     */
    public static <T extends Human> T createHuman(Class<T> c) {
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
