package com.gorden5566.learn.pattern.builder.demo.builder;

import com.gorden5566.learn.pattern.builder.demo.car.BMWModel;
import com.gorden5566.learn.pattern.builder.demo.car.CarModel;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder {
    private BMWModel bmw = new BMWModel();

    public CarModel getCarModel() {
        return this.bmw;
    }

    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }
}
