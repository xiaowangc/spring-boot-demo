package com.chige.controller;

import com.chige.domain.Guest;
import com.chige.domain.Response;
import com.chige.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/guest")
public class GuestController {

    //目前应该是service层发生错误
    @Autowired
    private GuestService guestService;
    private Map<Integer, Guest> map = new HashMap<>();


    @GetMapping
    public Response list(Model model){
        model.addAttribute("guestList",guestService.allGuests());
        return new Response(guestService.allGuests());
    }

    @PostMapping
    public String add(@RequestBody Guest guest){
        guestService.addOne(guest);
        //接受前端传过来的name 和 role值
        return "redirect:/guest";
    }

    /**
     *  将/guest/toUpdate/{name}格式的url映射到此方法
     *  其中的name属性值 通过注解 @PathVariable("name") 映射到此方法中
     *  其中的 "name" 代表去url中查找的属性值，直译的意思就是从路径中获取name值
     * @param model
     * @param name
     * @return
     */
    @GetMapping("/toUpdate/{name}")
    public String toUpdate(Model model,@PathVariable("name") String name){
        model.addAttribute("guest",guestService.selectOne(name));
        return "update";
    }

    @PutMapping
    public String update(Guest guest){
        guestService.updateOne(guest);
        return "redirect:/guest";
    }
    @DeleteMapping("/name/{name}")
    public String toDelete(@PathVariable("name") String name){
        guestService.deleteOne(name);
        return "redirect:/guest";
    }
    @PatchMapping
    public Response updateName(@RequestBody Guest guest) {
        boolean updateOne = guestService.updateOne(guest);
        Guest guest1 = guestService.selectOne(guest.getName());
        log.info("更新后为:{}", guest1);
        return new Response(updateOne);
    }

}

//TODO 如何跳转到另一个html，并将返回值带过去?
