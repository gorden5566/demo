package com.gorden5566.learn.pattern.builder.simple.builder;

import com.gorden5566.learn.pattern.builder.simple.car.BMWModel;
import com.gorden5566.learn.pattern.builder.simple.car.CarModel;

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
