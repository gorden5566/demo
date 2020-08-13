package com.gorden5566.demos.excel;

import java.lang.annotation.*;

/**
 * 列属性信息 see: xxl-excel
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelField {

    /**
     * 列名称
     *
     * @return
     */
    String name() default "";

    /**
     * 时间格式化，日期类型时生效
     *
     * @return
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
}

