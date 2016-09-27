package com.gorden5566.demos.properties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class LoadPropertiesTest {
    private static final Logger logger = LoggerFactory.getLogger(LoadPropertiesTest.class);

    @Test
    public void test() {
        LoadProperties loadProperties = new LoadProperties("test.properties");
        Properties properties = loadProperties.load();
        logger.info("version: " + properties.getProperty("version"));
        logger.info("version: " + properties.getProperty("default.url"));
    }
}