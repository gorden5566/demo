package com.gorden5566.demos.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Excel导入工具 see: xxl-excel
 */
public class ExcelImportUtils {
    private static Logger logger = LoggerFactory.getLogger(ExcelImportUtils.class);

    /**
     * 解析excel的第一个sheet为sheetClass对象
     * 注：第一行为title,名称需和sheetClass中的注解名保持一致
     *
     * @param filePath
     * @param sheetClass
     * @return
     */
    public static <T> ExcelResult<List<T>> parseExcel(String filePath, Class<T> sheetClass) {
        try {
            File excelFile = new File(filePath);
            Workbook workbook = WorkbookFactory.create(excelFile);
            ExcelResult<List<T>> result = parseExcel(workbook, sheetClass);
            return result;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析excel的第一个sheet为sheetClass对象
     * 注：第一行为title,名称需和sheetClass中的注解名保持一致
     *
     * @param inputStream
     * @param sheetClass
     * @return
     */
    public static <T> ExcelResult<List<T>> parseExcel(InputStream inputStream, Class<T> sheetClass) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            ExcelResult<List<T>> result = parseExcel(workbook, sheetClass);
            return result;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析excel的第一个sheet为sheetClass对象
     * 注：第一行为title,名称需和sheetClass中的注解名保持一致
     *
     * @param workbook
     * @param sheetClass
     * @return
     */
    public static <T> ExcelResult<List<T>> parseExcel(Workbook workbook, Class<T> sheetClass) {
        try {
            List<T> dataList = new ArrayList<T>();

            // 属性注解名 -> 属性
            Map<String, Field> fieldNameMap = parseSheetClass(sheetClass);

            // 只处理第一个sheet
            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                logger.error("sheet为空");
                return ExcelResult.failResult("sheet不存在");
            }

            // 解析title
            Map<String, Integer> titleIndexMap = parseSheetTitleIndex(sheet);

            int missTitleCount = 0;
            int errorCount = 0;
            StringBuilder errorMsgSb = new StringBuilder();
            errorMsgSb.append("请检查Excel：");

            int rowIndex = 0;
            Iterator<Row> sheetIterator = sheet.rowIterator();
            while (sheetIterator.hasNext()) {
                Row rowX = sheetIterator.next();
                if (rowIndex > 0)  {
                    // 解析一行数据
                    T rowObj = sheetClass.newInstance();

                    for (Map.Entry<String, Field> entry : fieldNameMap.entrySet()) {
                        String name = entry.getKey();
                        Field field = entry.getValue();

                        // 根据属性名称获取在sheet中的列下标
                        Integer fieldIndex = titleIndexMap.get(name);
                        if (fieldIndex == null) {
                            missTitleCount++;
                            errorMsgSb.append("未找到列[").append(name).append("]").append("; ");
                            continue;
                        }

                        // cell
                        Cell cell = rowX.getCell(fieldIndex);
                        if (cell == null) {
                            logger.warn("empty cell data, " + name + ", index: " + rowIndex);
                            errorCount++;
                            errorMsgSb.append("列[").append(name).append("]不能为空;");
                            continue;
                        }

                        // 以文本格式获取单元格内容(sheet务必设置为：单元格格式->文本)
                        cell.setCellType(CellType.STRING);
                        String fieldValueStr = cell.getStringCellValue();

                        // 根据属性类型解析数据
                        Object fieldValue = null;
                        try {
                            fieldValue = FieldReflectionUtils.parseValue(field, fieldValueStr);
                        } catch (Exception e) {
                            logger.warn("invalid cell data, title: " + name + ", index: " + rowIndex, e);
                            errorCount++;
                            errorMsgSb.append("第").append(cell.getAddress().getRow() + 1).append("行")
                                .append("第").append(cell.getAddress().getColumn() + 1).append("列")
                                .append("[").append(fieldValueStr).append("]").append(", ");
                        }
                        if (fieldValue == null) {
                            continue;
                        }

                        // 设置数据
                        field.setAccessible(true);
                        field.set(rowObj, fieldValue);
                    }

                    if (missTitleCount > 0) {
                        break;
                    }

                    dataList.add(rowObj);
                }
                rowIndex++;
            }
            if (missTitleCount > 0 || errorCount > 0) {
                return ExcelResult.failResult(errorMsgSb.toString());
            }
            return ExcelResult.successResult(dataList);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 提取sheetClass的属性
     *
     * @param sheetClass
     * @return
     */
    private static Map<String, Field> parseSheetClass(Class<?> sheetClass) {
        // 获取类的所有非静态属性
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
            throw new RuntimeException("类没有非静态属性: " + sheetClass.getName());
        }

        // 属性注解名 -> 属性
        Map<String, Field> fieldNameMap = new HashMap<String, Field>();
        for (Field field : fields) {
            ExcelField annotation = field.getAnnotation(ExcelField.class);
            // 未配置注解则不处理
            if (annotation == null) {
                continue;
            }
            String name = annotation.name();
            if (name == null) {
                continue;
            }
            fieldNameMap.put(name, field);
        }

        if (fieldNameMap.isEmpty()) {
            throw new RuntimeException("类未配置属性注解: " + sheetClass.getName());
        }
        return fieldNameMap;
    }

    /**
     * 解析excel标题下标
     *
     * @param sheet
     * @return
     */
    private static Map<String, Integer> parseSheetTitleIndex(Sheet sheet) {
        Iterator<Row> sheetIterator = sheet.rowIterator();
        Map<String, Integer> filedIndexMap = new HashMap<String, Integer>();
        if (sheetIterator.hasNext()) {
            // 取第一行title
            Row rowX = sheetIterator.next();
            for (int colIndex = rowX.getFirstCellNum(); colIndex < rowX.getLastCellNum(); colIndex++) {
                Cell cell = rowX.getCell(colIndex);

                cell.setCellType(CellType.STRING);
                String fieldValueStr = cell.getStringCellValue();

                filedIndexMap.put(fieldValueStr, colIndex);
            }
        }
        if (filedIndexMap.isEmpty()) {
            throw new RuntimeException("excel标题不能为空");
        }
        return filedIndexMap;
    }
}
