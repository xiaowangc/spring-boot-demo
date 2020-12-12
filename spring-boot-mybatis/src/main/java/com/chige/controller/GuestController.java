package com.chige.controller;

import com.chige.domain.Guest;
import com.chige.service.GuestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestController {

    //目前应该是service层发生错误
    @Autowired
    private GuestServiceImp guestService;


    @RequestMapping("/guest")
    public String list(Model model){
        model.addAttribute("guestList",guestService.allGuests());
        return "list";
    }

}

//TODO 如何跳转到另一个html，并将返回值带过去?
