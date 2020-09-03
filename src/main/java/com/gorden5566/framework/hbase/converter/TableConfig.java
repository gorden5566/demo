package com.gorden5566.framework.hbase.converter;

import org.apache.hadoop.hbase.util.Bytes;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class TableConfig {
    private String tableName;
    private String familyKey;
    private byte[] family;

    public static TableConfig newConfig(String tableName, String familyKey) {
        TableConfig config = new TableConfig();
        config.setTableName(tableName);
        config.setFamilyKey(familyKey);
        config.setFamily(Bytes.toBytes(familyKey));

        return config;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFamilyKey() {
        return familyKey;
    }

    public void setFamilyKey(String familyKey) {
        this.familyKey = familyKey;
    }

    public byte[] getFamily() {
        return family;
    }

    public void setFamily(byte[] family) {
        this.family = family;
    }
}
