package com.gorden5566.framework.hbase.demo;

import java.util.List;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class DemoDto {
    private String rowKey;

    private Integer id;
    private String name;
    private List<String> data;

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
