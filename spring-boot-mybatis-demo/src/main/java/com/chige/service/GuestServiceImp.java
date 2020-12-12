package com.chige.service;

import com.chige.domain.Guest;
import com.chige.mapper1.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImp implements GuestService{

    @Autowired
    private GuestMapper guestMapper;

    /**
     * 获取所有嘉宾信息
     *
     * @return
     */
    @Override
    public List<Guest> allGuests() {
        return guestMapper.allGuests();
    }


}
