package com.chige.controller;

import com.chige.domain.Guest;
import com.chige.service.GuestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {

    //目前应该是service层发生错误
    @Autowired
    private GuestServiceImp guestService;


    @RequestMapping("/guest/list")
    public String list(Model model){

        model.addAttribute("guestList",guestService.allGuests());
        return "list";
    }

    @RequestMapping("/guest/toAdd")
    public String toAdd(Model model){
        return "add";
    }

    @RequestMapping("/guest/add")
    public String add(Guest guest){
        guestService.addOne(guest);
        //接受前端传过来的name 和 role值
        return "redirect:/guest/list";
    }

    @RequestMapping("/guest/toUpdate")
    public String toUpdate(Model model,String name){
        model.addAttribute("guest",guestService.selectOne(name));
        return "update";
    }
    @RequestMapping("/guest/update")
    public String update(Guest guest){
        guestService.updateOne(guest);
        return "redirect:list";
    }
    @RequestMapping("/guest/toDelete")
    public String toDelete(String name){
        guestService.deleteOne(name);

        return "redirect:list";
    }

}

//TODO 如何跳转到另一个html，并将返回值带过去?
