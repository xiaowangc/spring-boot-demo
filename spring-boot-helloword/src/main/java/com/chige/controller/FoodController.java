package com.chige.controller;

import com.chige.bean.Beaf;
import com.chige.bean.Food;
import com.chige.openfeign.config.FoodConfig;
import com.chige.exception.Response;
import com.chige.exception.ResponseException;
import com.chige.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController 相当于@Controller + @RequestBody的组合
 * 返回JSON的格式，而不是视图（jsp html）
 */
@Slf4j
@RestController
public class FoodController {
    @Autowired
    private FoodConfig foodConfig;

    @RequestMapping("/json/{name}")
    public Food eat(@PathVariable("name") String name) {
        Food food = new Food();
        food.setMeat(foodConfig.getMeat());
        food.setRice(foodConfig.getRice());
        return food;
    }

    @RequestMapping(value = "/json/beaf",method = RequestMethod.POST)
    public Response getBeaf(@RequestBody Beaf beaf){
        Response response = new Response();
        log.info(beaf.toString());
        beaf.getRice();
        String meat = beaf.getMeat();
        return response;
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public Response insert(@RequestBody @Validated Food food) {
        Response response = new Response();
        try {
            ValidatorUtil.validate(food);

        } catch (ResponseException e) {
            response = new Response(e.getResponseCode());
            return response;
        }

        log.info("前端参数为{}", food.toString());
        response.setData("处理成功");
        return response;
    }
}
