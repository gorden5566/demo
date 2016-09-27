package com.gorden5566.demos.properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    private static final Log logger = LogFactory.getLog(LoadProperties.class);

    private String fileName;

    public LoadProperties(String fileName) {
        this.fileName = fileName;
    }

    public Properties load() {
        ClassLoader classLoader = LoadProperties.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        Properties props = new Properties();
        if (inputStream != null) {
            try {
                props.load(inputStream);
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }

        return props;
    }
}
