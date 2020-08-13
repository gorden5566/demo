package com.gorden5566.demos.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel导出工具 see:xxl-excel
 */
public class ExcelExportUtils {
    private static Logger logger = LoggerFactory.getLogger(ExcelExportUtils.class);


    /**
     * 导出Excel对象
     *
     * @param sheetDataListArr  Excel数据
     * @return
     */
    public static Workbook exportWorkbook(List<?>... sheetDataListArr){

        // data array valid
        if (sheetDataListArr==null || sheetDataListArr.length==0) {
            throw new RuntimeException("data array can not be empty.");
        }

        // book （HSSFWorkbook=2003/xls、XSSFWorkbook=2007/xlsx）
        Workbook workbook = new HSSFWorkbook();

        // sheet
        for (List<?> dataList: sheetDataListArr) {
            makeSheet(workbook, dataList);
        }

        return workbook;
    }

    private static void makeSheet(Workbook workbook, List<?> sheetDataList){
        // data
        if (sheetDataList==null || sheetDataList.size()==0) {
            throw new RuntimeException("data can not be empty.");
        }

        // sheet
        Class<?> sheetClass = sheetDataList.get(0).getClass();

//        String sheetName = sheetDataList.get(0).getClass().getSimpleName();
        String sheetName = "sheet";
        int headColorIndex = -1;

        Sheet existSheet = workbook.getSheet(sheetName);
        if (existSheet != null) {
            for (int i = 2; i <= 1000; i++) {
                String newSheetName = sheetName.concat(String.valueOf(i));
                existSheet = workbook.getSheet(newSheetName);
                if (existSheet == null) {
                    sheetName = newSheetName;
                    break;
                } else {
                    continue;
                }
            }
        }

        Sheet sheet = workbook.createSheet(sheetName);

        // 单元格默认格式
        CellStyle defaultCellStyle = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        defaultCellStyle.setDataFormat(dataFormat.getFormat("@"));

        // sheet field
        List<Field> fields = new ArrayList<Field>();
        if (sheetClass.getDeclaredFields()!=null && sheetClass.getDeclaredFields().length>0) {
            for (Field field: sheetClass.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                fields.add(field);
            }
        }

        if (fields==null || fields.size()==0) {
            throw new RuntimeException("data field can not be empty.");
        }

        // 标题
        CellStyle[] fieldDataStyleArr = new CellStyle[fields.size()];
        int[] fieldWidthArr = new int[fields.size()];
        Row headRow = sheet.createRow(0);
        int titleColIndex = 0;
        for (int i = 0; i < fields.size(); i++) {

            // field
            Field field = fields.get(i);
            ExcelField excelField = field.getAnnotation(ExcelField.class);
            // 无注解不处理
            if (excelField == null) {
                continue;
            }

            // 默认格式
            sheet.setDefaultColumnStyle(titleColIndex, defaultCellStyle);

            String fieldName = field.getName();
            int fieldWidth = 0;
            HorizontalAlignment align = null;

            if (excelField.name()!=null && excelField.name().trim().length()>0) {
                fieldName = excelField.name().trim();
            }

            // field width
            fieldWidthArr[i] = fieldWidth;

            // head-style、field-data-style
            CellStyle fieldDataStyle = workbook.createCellStyle();
            if (align != null) {
                fieldDataStyle.setAlignment(align);
            }
            fieldDataStyleArr[i] = fieldDataStyle;

            CellStyle headStyle = workbook.createCellStyle();
            headStyle.cloneStyleFrom(fieldDataStyle);
            if (headColorIndex > -1) {
                headStyle.setFillForegroundColor((short) headColorIndex);
                headStyle.setFillBackgroundColor((short) headColorIndex);
                headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }

            // head-field data
            Cell cellX = headRow.createCell(titleColIndex, CellType.STRING);
            cellX.setCellStyle(headStyle);
            cellX.setCellValue(String.valueOf(fieldName));

            titleColIndex++;
        }

        // 数据
        for (int dataIndex = 0; dataIndex < sheetDataList.size(); dataIndex++) {
            int rowIndex = dataIndex+1;
            Object rowData = sheetDataList.get(dataIndex);

            Row rowX = sheet.createRow(rowIndex);

            int dataColIndex = 0;
            for (int i = 0; i < fields.size(); i++) {
                Field field = fields.get(i);
                ExcelField excelField = field.getAnnotation(ExcelField.class);
                // 无注解则不处理
                if (excelField == null) {
                    continue;
                }
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(rowData);

                    String fieldValueString = FieldReflectionUtils.formatValue(field, fieldValue);

                    Cell cellX = rowX.createCell(dataColIndex, CellType.STRING);
                    cellX.setCellValue(fieldValueString);
                    cellX.setCellStyle(fieldDataStyleArr[i]);
                    cellX.setCellStyle(defaultCellStyle);
                } catch (IllegalAccessException e) {
                    logger.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
                dataColIndex++;
            }
        }

        // sheet finally
        for (int i = 0; i < fields.size(); i++) {
            int fieldWidth = fieldWidthArr[i];
            if (fieldWidth > 0) {
                sheet.setColumnWidth(i, fieldWidth);
            } else {
                sheet.autoSizeColumn((short)i);
            }
        }
    }

    /**
     * 导出Excel文件到磁盘
     *
     * @param filePath
     * @param sheetDataListArr  数据，可变参数，如多个参数则代表导出多张Sheet
     */
    public static void exportToFile(String filePath, List<?>... sheetDataListArr){
        // workbook
        Workbook workbook = exportWorkbook(sheetDataListArr);

        FileOutputStream fileOutputStream = null;
        try {
            // workbook 2 FileOutputStream
            fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            // flush
            fileOutputStream.flush();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 导出Excel字节数据
     *
     * @param sheetDataListArr
     * @return
     */
    public static byte[] exportToBytes(List<?>... sheetDataListArr){
        // workbook
        Workbook workbook = exportWorkbook(sheetDataListArr);

        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] result = null;
        try {
            // workbook 2 ByteArrayOutputStream
            byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);

            // flush
            byteArrayOutputStream.flush();

            result = byteArrayOutputStream.toByteArray();
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
