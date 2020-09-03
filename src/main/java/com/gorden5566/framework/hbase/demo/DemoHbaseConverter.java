package com.gorden5566.framework.hbase.demo;

import com.alibaba.fastjson.TypeReference;
import com.gorden5566.framework.hbase.converter.AbstractHbaseConverter;
import com.gorden5566.framework.hbase.converter.ColumnConfig;
import com.gorden5566.framework.hbase.converter.PutBuilder;
import com.gorden5566.framework.hbase.converter.TableConfig;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.List;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class DemoHbaseConverter extends AbstractHbaseConverter<DemoDto> {
    private static final ColumnConfig id = ColumnConfig.newConfig("id", Integer.class);
    private static final ColumnConfig name = ColumnConfig.newConfig("name", String.class);
    private static final ColumnConfig data = ColumnConfig.newConfig("data", new TypeReference<List<String>>() {}.getType());

    private static final String TABLE_NAME = "table-name";
    private static final String FAMILY_KEY = "family-key";

    @Override
    protected TableConfig buildTableConfig() {
        return TableConfig.newConfig(TABLE_NAME, FAMILY_KEY);
    }

    @Override
    protected PutBuilder buildPutBuilder(DemoDto dto) {
        PutBuilder builder = PutBuilder.newBuilder(tableConfig).rowKey(dto.getRowKey());

        builder.addColumn(id, dto.getId());
        builder.addColumn(name, dto.getName());
        builder.addColumn(data, dto.getData());

        return builder;
    }

    @Override
    protected DemoDto doParseRow(Result result) {
        DemoDto dto = new DemoDto();

        dto.setRowKey(Bytes.toString(result.getRow()));

        dto.setId(parseColumn(result, id));
        dto.setName(parseColumn(result, name));
        dto.setData(parseColumn(result, data));

        return dto;
    }
}
