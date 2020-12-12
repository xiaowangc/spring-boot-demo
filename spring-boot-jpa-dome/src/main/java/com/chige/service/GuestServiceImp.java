package com.chige.service;

import com.chige.dao.GuestDao;
import com.chige.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImp implements GuestService{

    @Autowired
    private GuestDao guestDao;

    /**
     * 获取所有嘉宾信息
     *
     * @return
     */
    @Override

    public List<Guest> allGuests() {
        return guestDao.allGuests();
    }


}
