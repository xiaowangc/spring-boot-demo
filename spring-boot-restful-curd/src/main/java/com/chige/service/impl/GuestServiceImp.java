package com.chige.service.impl;

import com.chige.dao.GuestDao;
import com.chige.domain.Guest;
import com.chige.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImp implements GuestService {

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

    /**
     * 增加嘉宾  返回值为：成功或失败
     *
     * @param guest
     * @return
     */
    @Override
    public boolean addOne(Guest guest) {
        return guestDao.addOne(guest);
    }

    /**
     * 根据姓名删除嘉宾
     *
     * @param name
     * @return
     */
    @Override
    public boolean deleteOne(String name) {
        return guestDao.deleteOne(name);
    }

    /**
     * 更新某一位嘉宾的角色
     *
     * @param guest
     * @return
     */
    @Override
    public boolean updateOne(Guest guest) {
        return guestDao.updateRole(guest);
    }

    @Override
    public Guest selectOne(String name) {
        return guestDao.selectOne(name);
    }
}
