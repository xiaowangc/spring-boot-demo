package com.chige.excel.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 下载文件
 * todo 代码无法跑通
 * @author wangyc
 * @date 2023/11/7
 */
@RestController
@RequestMapping("/download")
public class DownloadFromServerController {

    @PostMapping("/excel")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        String dataFileName = "测试";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + java.net.URLEncoder.encode(dataFileName, "UTF-8") + ".xlsx" + "\" ");

        List<Person> list = this.initData();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.addHeaderAlias("name", "姓名");

        writer.write(list, true);
        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream);
        writer.close();
        IoUtil.close(outputStream);
    }


    private List<Person> initData() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("王一", 1));
        list.add(new Person("王二", 13));
        list.add(new Person("李三", 10));
        return list;
    }

    @AllArgsConstructor
    @Data
    static class Person {
        private String name;
        private Integer age;

    }

}
