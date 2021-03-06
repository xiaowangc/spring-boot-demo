package com.chige.dao;

import com.chige.domain.Guest;
import com.sun.java.accessibility.util.GUIInitializedListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Scope()
@Repository
public class GuestDao {


     static List<Guest> guestList = new ArrayList<>();
     static {
        guestList.add(new Guest("黄晓明","总经理"));
        guestList.add(new Guest("林大厨","厨师"));
        guestList.add(new Guest("杨紫","财务"));
        guestList.add(new Guest("王源","前台"));
        guestList.add(new Guest("张一山","店小二"));

    }
    public List<Guest> allGuests(){
        return guestList;
    }

    /**
     * 根据姓名删除一个嘉宾
     * @param name
     * @return
     */
    public boolean deleteOne(String name){

        Guest guest = selectOne(name);
        if(guest != null){
            guestList.remove(guest);
            return true;
        }
        return false;
    }

    /**
     * 添加嘉宾
     * @param guest
     * @return
     */
    public boolean addOne(Guest guest){
        return guestList.add(guest);
    }

    /**
     *  修改嘉宾角色
     * @param guest
     * @return
     */
    //TODO 验证是否能更新成功
    public boolean updateRole(Guest guest){
        Guest guest1 = selectOne(guest.getName());
        if(guest1 != null){
            guest1.setRole(guest.getRole());
            return true;
        }
        return false;
    }

    public Guest selectOne(String name){
        for(Guest guest : guestList){
            if(guest.getName().equals(name)){
                return guest;
            }
        }
        return null;
    }

}
