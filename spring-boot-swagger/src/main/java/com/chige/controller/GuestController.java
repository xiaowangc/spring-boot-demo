package com.chige.controller;

import com.chige.domain.Guest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/guest")
@Api(tags = "嘉宾相关的接口",description = "对嘉宾进行CURD的接口")
public class GuestController {

    @GetMapping
    @ApiOperation("显示所有嘉宾信息")
    public String list(){
        return "list";
    }

    @GetMapping("/toAdd")
    @ApiIgnore
    public String toAdd(Model model){
        return "add";
    }
    //增加人员时：试下POSTmapping 和 PUTMappping

    @PostMapping
    @ApiOperation("增加嘉宾")
    public String add(){
        return "add guest";
    }

    /**
     *  将/guest/toUpdate/{name}格式的url映射到此方法
     *  其中的name属性值 通过注解 @PathVariable("name") 映射到此方法中
     *  其中的 "name" 代表去url中查找的属性值，直译的意思就是从路径中获取name值
     *
     * @param name
     * @return
     */
    @GetMapping("/toUpdate/{name}")
    @ApiIgnore
    public String toUpdate(@PathVariable("name") String name){
        return "update";
    }

    @PutMapping
    @ApiOperation("更新嘉宾信息")
    public String update(Guest guest){
        return "update guest";
    }
    @DeleteMapping("/{name}")
    @ApiImplicitParam(name = "name",value = "姓名")
    @ApiOperation("删除指定嘉宾信息")
    public String toDelete(@PathVariable("name") String name){
        return " delete guest";
    }

}

