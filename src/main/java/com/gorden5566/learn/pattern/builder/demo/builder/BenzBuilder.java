package com.gorden5566.learn.pattern.builder.demo.builder;

import com.gorden5566.learn.pattern.builder.demo.car.BenzModel;
import com.gorden5566.learn.pattern.builder.demo.car.CarModel;

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
