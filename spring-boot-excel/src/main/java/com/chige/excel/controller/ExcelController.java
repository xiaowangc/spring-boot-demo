package com.chige.excel.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** todo 未完成，接口未调通
 * @author wangyc
 * @date 2023/8/8
 */
@RestController
public class ExcelController {

    @RequestMapping(value = "/exportEmp", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("1","王1"));
        list.add(new Employee("2","王2"));
        return PoiUtils.exportEmp2Excel(list);
    }

    public static class PoiUtils {

        public static ResponseEntity<byte[]> exportEmp2Excel(List<Employee> emps) {
            HttpHeaders headers = null;
            ByteArrayOutputStream baos = null;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("XXX集团员工信息表");
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("编号");
            try {
                //生成Excel，出于篇幅考虑，这里省略掉，小伙伴可以直接在源码中查看
                headers = new HttpHeaders();
                headers.setContentDispositionFormData("attachment", new String("员工表.xls".getBytes("UTF-8"), "iso-8859-1"));
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                baos = new ByteArrayOutputStream();
                workbook.write(baos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
        }
    }

    @AllArgsConstructor
    @Data
    static class Employee {
        private String userId;
        private String name;
    }

}
