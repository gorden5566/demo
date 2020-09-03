package com.gorden5566.framework.hbase.converter;

import com.gorden5566.framework.hbase.HbaseConverter;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public abstract class AbstractHbaseConverter<T> implements HbaseConverter<T> {
    private static final int MAX_COUNT = 100;

    private ColumnParser columnParser;
    protected TableConfig tableConfig;

    public AbstractHbaseConverter() {
        this.tableConfig = buildTableConfig();
        this.columnParser = ColumnParser.getInstance(tableConfig);
    }

    @Override
    public String getTableName() {
        return tableConfig.getTableName();
    }

    @Override
    public byte[] getFamily() {
        return tableConfig.getFamily();
    }

    @Override
    public PutBuilder newPutBuilder(T object) {
        PutBuilder builder = buildPutBuilder(object);
        // do check

        return builder;
    }

    @Override
    public T parseRow(Result result) {
        return doParseRow(result);
    }

    @Override
    public List<T> parseRows(ResultScanner scanner, Integer limit) {
        if (limit == null || limit > MAX_COUNT) {
            limit = MAX_COUNT;
        }

        List<T> records = new ArrayList<>();
        int count = 0;
        for (Result result : scanner) {
            if (count >= limit) {
                break;
            }
            count++;

            T record = this.parseRow(result);
            records.add(record);
        }

        return records;
    }

    /**
     * init table config
     *
     * @return
     */
    protected abstract TableConfig buildTableConfig();

    /**
     * create new PutBuilder
     *
     * @param object
     * @return
     */
    protected abstract PutBuilder buildPutBuilder(T object);

    /**
     * parse row data
     *
     * @param result
     * @return
     */
    protected abstract T doParseRow(Result result);

    protected <T> T parseColumn(Result result, ColumnConfig config) {
        return columnParser.parseColumn(result, config);
    }
}
