package com.gorden5566.demos.properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Properties;

public class LoadPropertiesTest {
    private static final Log logger = LogFactory.getLog(LoadPropertiesTest.class);

    @Test
    public void test() {
        LoadProperties loadProperties = new LoadProperties("test.properties");
        Properties properties = loadProperties.load();
        logger.info("version: " + properties.getProperty("version"));
        logger.info("version: " + properties.getProperty("default.url"));
    }
}