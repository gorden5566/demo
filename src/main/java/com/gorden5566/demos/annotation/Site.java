package com.gorden5566.demos.annotation;

import com.gorden5566.demos.annotation.definition.ColumnDefinition;
import com.gorden5566.demos.annotation.definition.TableDefinition;

@TableDefinition(name = "T_SITE")
public class Site {
    @ColumnDefinition(name = "ID")
    private Integer id;

    @ColumnDefinition(name = "SITE_NAME")
    private String name;

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
}
