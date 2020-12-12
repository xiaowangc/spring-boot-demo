package com.chige.controller;

import com.chige.domain.Guest;
import com.chige.service.GuestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestServiceImp guestService;

    @GetMapping()  //执行一个请求方法
    public String list(Model model){
        model.addAttribute("guestList",guestService.list());
        return "list";
    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "/add";
    }

//    @Transactional
    @PostMapping("")
    public String add(Guest guest){
        guestService.save(guest);
        return "redirect:/guest";
    }



}


