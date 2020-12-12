package com.chige.controller;

import com.chige.domain.Guest;
import com.chige.service.GuestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest")
public class GuestController {

    //目前应该是service层发生错误
    @Autowired
    private GuestServiceImp guestService;


    @GetMapping
    public String list(Model model){
        model.addAttribute("guestList",guestService.allGuests());
        return "list";
    }

    @GetMapping("/toAdd")
    public String toAdd(Model model){
        return "add";
    }
    //增加人员时：试下POSTmapping 和 PUTMappping

    @PostMapping
    public String add(Guest guest){
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
    @DeleteMapping("/{name}")
    public String toDelete(@PathVariable("name") String name){
        guestService.deleteOne(name);
        return "redirect:/guest";
    }

}

//TODO 如何跳转到另一个html，并将返回值带过去?
