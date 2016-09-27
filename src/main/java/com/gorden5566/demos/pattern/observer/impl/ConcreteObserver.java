package com.gorden5566.demos.pattern.observer.impl;

import com.gorden5566.demos.pattern.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteObserver implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteObserver.class);

    private Long id;

    public ConcreteObserver(Long id) {
        this.id = id;
    }

    @Override
    public void update(String info) {
        logger.info("id: " + id + ", message: " +info);
    }
}
