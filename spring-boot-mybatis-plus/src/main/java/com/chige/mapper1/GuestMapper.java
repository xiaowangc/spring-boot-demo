package com.chige.mapper1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chige.domain.Guest;

//@Mapper 之所以不用写这个注解，主要是在程序入口处加了MapperScan注解
public interface GuestMapper extends BaseMapper<Guest> {


}
