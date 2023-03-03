package com.chige.mapper3;

import com.chige.domain.Guest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wangyc
 * @date 2023/3/2
 */
public interface GuestMapper3 {

    @Select("select id, user_id, name, age from user_info")
    List<Guest> allGuests();
}
