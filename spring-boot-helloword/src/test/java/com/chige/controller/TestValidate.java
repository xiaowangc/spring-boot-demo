package com.chige.controller;

import com.chige.bean.Food;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestValidate {

    @Autowired
    private FoodController foodController;

    @Test
    public void testValidate(){
        Food food = new Food("米饭"," ");
        foodController.insert(food);
    }

}
