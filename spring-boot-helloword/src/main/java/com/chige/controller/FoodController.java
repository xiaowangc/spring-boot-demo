package com.chige.controller;

import com.chige.bean.Food;
import com.chige.config.FoodConfig;
import com.chige.exception.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController 相当于@Controller + @RequestBody的组合
 *  返回JSON的格式，而不是视图（jsp html）
 */
@Slf4j
@RestController
public class FoodController {
    @Autowired
    private FoodConfig foodConfig;
    @RequestMapping("/json/{name}")
    public Food eat(@PathVariable("name")String name){
        Food food = new Food();
        food.setMeat(foodConfig.getMeat());
        food.setRice(foodConfig.getRice());
        return food;
    }

    @RequestMapping("/json")
    public Response insert(Food food){
        Food food1 = new Food(food.getRice(),food.getMeat());
        log.info("收到前端传来的参数对象，为{}",food1);
        Response response = new Response();
        response.setData("处理成功");
        return response;
    }
}
