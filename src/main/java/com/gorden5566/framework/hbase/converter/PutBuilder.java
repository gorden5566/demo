package com.gorden5566.framework.hbase.converter;

import com.gorden5566.framework.hbase.Serializer;
import com.gorden5566.framework.hbase.SerializerFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;

import static org.apache.hadoop.hbase.client.Durability.SYNC_WAL;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class PutBuilder {
    private TableConfig tableConfig;
    private String rowKey;
    private List<Column> columns = new ArrayList<>();


    public TableConfig getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(TableConfig tableConfig) {
        this.tableConfig = tableConfig;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public static PutBuilder newBuilder(TableConfig tableConfig) {
        PutBuilder builder = new PutBuilder();
        builder.setTableConfig(tableConfig);
        return builder;
    }

    public PutBuilder rowKey(String rowKey) {
        this.rowKey = rowKey;
        return this;
    }

    public PutBuilder addColumn(byte[] columnName, Object columnValue) {
        this.columns.add(new Column(columnName, columnValue));
        return this;
    }

    public PutBuilder addColumn(ColumnConfig config, Object columnValue) {
        this.columns.add(new Column(config.getQualifier(), columnValue));
        return this;
    }

    public Put build() {
        Put put = new Put(Bytes.toBytes(rowKey));
        byte[] family = Bytes.toBytes(tableConfig.getFamilyKey());
        for (Column column : columns) {
            byte[] qualifier = column.getName();

            // 转换为JsonString存储
            Serializer serializer = SerializerFactory.getDefaultSerializer();
            byte[] value = serializer.serialize(column.getValue());
            put.addColumn(family, qualifier, value);
        }
        put.setDurability(SYNC_WAL);

        return put;
    }
}
