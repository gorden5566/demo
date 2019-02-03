package com.gorden5566.learn.pattern.builder.simple.builder;

import com.gorden5566.learn.pattern.builder.simple.car.BenzModel;
import com.gorden5566.learn.pattern.builder.simple.car.CarModel;

import java.util.ArrayList;

public class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();

    public CarModel getCarModel() {
        return this.benz;
    }

    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }
}
