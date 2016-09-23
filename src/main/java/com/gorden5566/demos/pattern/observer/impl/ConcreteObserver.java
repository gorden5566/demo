package com.gorden5566.demos.pattern.observer.impl;

import com.gorden5566.demos.pattern.observer.Observer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConcreteObserver implements Observer {
    private static final Log logger = LogFactory.getLog(ConcreteObserver.class);

    private Long id;

    public ConcreteObserver(Long id) {
        this.id = id;
    }

    @Override
    public void update(String info) {
        logger.info("id: " + id + ", message: " +info);
    }
}
