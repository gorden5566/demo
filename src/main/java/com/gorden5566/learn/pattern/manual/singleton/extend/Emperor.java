package com.gorden5566.learn.pattern.manual.singleton.extend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Emperor {
    // 最多产生的实例数
    private static int maxNumOfEmperor = 2;

    // 每个皇帝都有一个名字,使用ArrayList存储对象的私有属性
    private static List<String> nameList = new ArrayList<>();

    // 存储所有的实例
    private static List<Emperor> emperorList = new ArrayList<>();

    // 当前皇帝的序号
    private static int countOfEmperor = 0;

    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new Emperor("皇" + (i+1) + "帝"));
        }
    }

    private Emperor() {
    }

    private Emperor(String name) {
        nameList.add(name);
    }

    public static Emperor getInstance() {
        Random random = new Random();
        countOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperorList.get(countOfEmperor);
    }

    public static void say() {
        System.out.println(nameList.get(countOfEmperor));
    }
}
