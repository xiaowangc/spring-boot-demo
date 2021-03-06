package com.chige.mapper1;

import com.chige.domain.Guest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper 之所以不用写这个注解，主要是在程序入口处加了MapperScan注解
public interface GuestMapper1 {

    @Select("select id, name, role from guest")
    List<Guest> allGuests();
}
