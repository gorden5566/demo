package com.gorden5566.demos.excel;

import lombok.Data;

/**
 * @author gorden5566
 * @date 2018/6/7
 */
@Data
public class ExcelResult<T> {
    private static final int SUCCESS = 0;
    private static final int FAIL = 1;

    private int code;

    /**
     * 错误提示信息
     */
    private String errorMsg;

    /**
     * 返回结果
     */
    public T data;

    public ExcelResult() {
        this.code = SUCCESS;
        this.errorMsg = "";
    }

    public boolean isSuccess() {
        return SUCCESS == code;
    }

    public static <T> ExcelResult<T> successResult(T data) {
        ExcelResult result = new ExcelResult();
        result.setData(data);
        return result;
    }

    public static <T> ExcelResult<T> failResult(String errorMsg) {
        ExcelResult result = new ExcelResult();
        result.setCode(FAIL);
        result.setErrorMsg(errorMsg);
        return result;
    }
}
