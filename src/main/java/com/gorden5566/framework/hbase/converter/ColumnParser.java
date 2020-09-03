package com.gorden5566.framework.hbase.converter;

import com.gorden5566.framework.hbase.Serializer;
import com.gorden5566.framework.hbase.SerializerFactory;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;

import java.lang.reflect.Type;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class ColumnParser {
    private TableConfig tableConfig;

    public TableConfig getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(TableConfig tableConfig) {
        this.tableConfig = tableConfig;
    }

    public static ColumnParser getInstance(TableConfig config) {
        ColumnParser parser = new ColumnParser();
        parser.setTableConfig(config);
        return parser;
    }

    protected <T> T parseColumn(Result result, byte[] columnName, Type clazz) {
        Cell latestCell = result.getColumnLatestCell(tableConfig.getFamily(), columnName);
        if (latestCell == null) {
            return null;
        }
        byte[] bytes = CellUtil.cloneValue(latestCell);
        Serializer serializer = SerializerFactory.getDefaultSerializer();
        return (T) serializer.deserialize(bytes, clazz);
    }

    protected <T> T parseColumn(Result result, ColumnConfig config) {
        return parseColumn(result, config.getQualifier(), config.getType());
    }
}
