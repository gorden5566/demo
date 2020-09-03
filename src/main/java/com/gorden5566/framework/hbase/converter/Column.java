package com.gorden5566.framework.hbase.converter;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class Column {
    private byte[] name;
    private Object value;

    public Column() {
    }

    public Column(byte[] name, Object value) {
        this.name = name;
        this.value = value;
    }

    public byte[] getName() {
        return name;
    }

    public void setName(byte[] name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
