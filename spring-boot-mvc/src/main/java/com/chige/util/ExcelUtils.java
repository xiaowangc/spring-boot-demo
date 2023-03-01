package com.chige.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel导出、导入工具类
 * 参考文章：https://blog.csdn.net/qq_39772439/article/details/122230213?spm=1001.2101.3001.6650.4&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-4-122230213-blog-123917816.pc_relevant_multi_platform_whitelistv4&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-4-122230213-blog-123917816.pc_relevant_multi_platform_whitelistv4&utm_relevant_index=6
 *
 * @author wangyc
 * @date 2022/8/23
 */
public class ExcelUtils<T> {

    private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 最大行数
     */
    public static final int sheetSize = 65536;
    /**
     * 定义工作表名称
     */
    private String sheetName;
    /**
     * 导出类型(EXPORT:导出数据、IMPORT:导入模板)
     */
    private Type type;

    /**
     * 工作簿对象
     */
    private Workbook workbook;

    /**
     * 工作表对象
     */
    private Sheet sheet;

    /**
     * 样式列表
     */
    private Map<String, CellStyle> styleMap;
    /**
     * 数据列表
     */
    private List<T> list;
    /**
     * 注解列表
     */
    private List<Object[]> fields;

    /**
     * 当前行号
     */
    private int rowNum;
    /**
     * 标题
     */
    private String title;

    /**
     * 最大高度
     */
    private short maxHeight;
    /**
     * 统计列表
     */
    private Map<Integer, Double> statistics = new HashMap<>();

    /**
     * 数字格式
     */

    /**
     * 实体对象
     */
    private Class<T> clazz;

    public ExcelUtils(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * 初始化数据
     *
     * @param list      数据源
     * @param sheetName 工作表名称
     * @param title     标题
     * @param type      导出/导入类型
     */
    public void init(List<T> list, String sheetName, String title, Type type) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.list = list;
        this.sheetName = sheetName;
        this.title = title;
        this.type = type;
    }

    /**
     * 创建excel第一行数据
     */
    public void createTitle() {
        if (StringUtils.isNotEmpty(sheetName)) {
            Row titleRow = sheet.createRow(rowNum == 0 ? rowNum++ : 0);
            titleRow.setHeightInPoints(30);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellStyle(styleMap.get("title"));
            titleCell.setCellValue(title);
            sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(), titleRow.getRowNum(), titleRow.getRowNum(),
                    this.fields.size() - 1));
        }
    }

    /**
     * 导出
     * 对list数据源的数据导入到excel中
     */
    public String exportExcel(List<T> list, String sheetName) {
        return exportExcel(list, sheetName, StringUtils.EMPTY);
    }

    private String exportExcel(List<T> list, String sheetName, String title) {
        this.init(list, sheetName, title, Type.EXPORT);
        return exportExcel();
    }

    public void exportExcel(HttpServletResponse response, List<T> list, String sheetName) {
        exportExcel(response, list, sheetName, StringUtils.EMPTY);
    }

    /**
     * 导出xls格式
     *
     * @param response
     * @param list
     * @param sheetName
     * @param title
     */
    public void exportExcel(HttpServletResponse response, List<T> list, String sheetName, String title) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + sheetName + ".xls");
        this.init(list, sheetName, title, Type.EXPORT);
        exportExcel(response);
    }

    private void exportExcel(HttpServletResponse response) {
        try {
            writheSheet();
            workbook.write(response.getOutputStream());
        }catch (Exception e) {
            log.error("导出excel异常，原因: {}", e.getMessage());
        }finally {
            IOUtils.closeQuietly(workbook);
        }
    }


    /**
     * 创建写入数据到sheet中
     */
    private void writheSheet() {
        // 取出一共有多少个sheet
        int sheetNo = Math.max(1, (int) Math.ceil(list.size() * 1.0 / sheetSize));
        for (int index = 0; index < sheetNo; index++) {
            createSheet();
        }
    }

    /**
     * 创建单元格
     */
    private Cell createSheet() {
        return null;
    }


    private String exportExcel() {
        return null;
    }


    public enum Type {
        EXPORT,
        IMPORT
    }
}
