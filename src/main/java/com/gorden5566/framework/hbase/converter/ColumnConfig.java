package com.gorden5566.framework.hbase.converter;

import org.apache.hadoop.hbase.util.Bytes;

import java.lang.reflect.Type;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class ColumnConfig {
    private byte[] qualifier;
    private String name;
    private Type type;

    public static ColumnConfig newConfig(String name, Type type) {
        ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setName(name);
        columnConfig.setType(type);
        columnConfig.setQualifier(Bytes.toBytes(name));

        return columnConfig;
    }

    public byte[] getQualifier() {
        return qualifier;
    }

    public void setQualifier(byte[] qualifier) {
        this.qualifier = qualifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
