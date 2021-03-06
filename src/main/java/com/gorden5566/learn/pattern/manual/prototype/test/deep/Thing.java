package com.gorden5566.learn.pattern.manual.prototype.test.deep;

import java.util.ArrayList;

public class Thing implements Cloneable {
    /**
     * 定义一个私有变量
     */
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
            thing.arrayList = (ArrayList<String>) thing.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return thing;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setValue(String value) {
        this.arrayList.add(value);
    }
}
