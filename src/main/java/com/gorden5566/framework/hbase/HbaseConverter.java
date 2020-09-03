package com.gorden5566.framework.hbase;

import com.gorden5566.framework.hbase.converter.PutBuilder;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

import java.util.List;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public interface HbaseConverter<T> {

    /**
     * get table name
     *
     * @return
     */
    String getTableName();

    /**
     * get family
     *
     * @return
     */
    byte[] getFamily();

    /**
     * create new PutBuilder
     *
     * @param object
     * @return
     */
    PutBuilder newPutBuilder(T object);

    /**
     * parse row data
     *
     * @param result
     * @return
     */
    T parseRow(Result result);

    /**
     * parse multi row
     *
     * @param scanner
     * @param limit
     * @return
     */
    List<T> parseRows(ResultScanner scanner, Integer limit);
}
