package com.gorden5566.demos.spi;

import java.util.ServiceLoader;

/**
 * @author gorden5566
 * @date 2019-03-08
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<DogService> dogServices = ServiceLoader.load(DogService.class);

        String a = "";
        for (DogService service : dogServices) {
            service.sleep();
        }
    }
}
