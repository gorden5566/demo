package com.gorden5566.demos.annotation;

import com.gorden5566.demos.annotation.definition.ColumnDefinition;
import com.gorden5566.demos.annotation.definition.TableDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DefinitionParser {
    private static final Log logger = LogFactory.getLog(DefinitionParser.class);

    public static void parse(Class<?> clazz) {
        // 获取type注解
        String tableName = new String();
        if (clazz.isAnnotationPresent(TableDefinition.class)) {
            TableDefinition table = clazz.getAnnotation(TableDefinition.class);
            tableName = table.name();
        }
        logger.info("tableName: " + tableName);

        // 获取field注解
        List<String> columnNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(ColumnDefinition.class)) {
                    ColumnDefinition column = field.getAnnotation(ColumnDefinition.class);
                    columnNames.add(column.name());
                }
            }
        }
        for (String name : columnNames) {
            logger.info("columnName: " + name);
        }
    }
}
