package com.gorden5566.demos.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    private static final Logger logger = LoggerFactory.getLogger(LoadProperties.class);

    private String fileName;

    public LoadProperties(String fileName) {
        this.fileName = fileName;
    }

    public Properties load() {
        // 获取当前类的ClassLoader
        ClassLoader classLoader = LoadProperties.class.getClassLoader();
        // 通过ClassLoader获取文件输入流
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        Properties props = new Properties();
        if (inputStream != null) {
            try {
                // 加载输入流
                props.load(inputStream);
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }

        return props;
    }
}
