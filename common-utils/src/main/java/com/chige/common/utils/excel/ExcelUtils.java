package com.chige.common.utils.excel;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * @author wangyc
 * @date 2023/8/17
 */
public class ExcelUtils {
    private ExcelUtils() {}

    public static void main(String[] args) {
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write();
    }

    public static <T> void writeExcel(String filePath, String sheetName, Class<T> clazz, List<T> data) {
        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(filePath, clazz);
        ExcelWriterSheetBuilder sheetBuilder = excelWriterBuilder.sheet();
        WriteSheet writeSheet = sheetBuilder.build();
        excelWriterBuilder.registerWriteHandler(new CustomCellWriteHandler()); // 注册自定义写入处理器
        excelWriterBuilder.writeExcelOnException(true); // 异常时是否继续写入
        excelWriterBuilder.doWrite(data, writeSheet);
    }

    public static class CustomCellWriteHandler implements CellWriteHandler {


        @Override
        public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

        }

        @Override
        public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean aBoolean) {

        }

        @Override
        public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

        }

        @Override
        public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {

        }
    }
}
