package com.chige.dynamicds.dynamicSourceStarter.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chige.dynamicds.dynamicSourceStarter.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@Mapper
@DS(value = "db1")
public interface UserDao extends BaseMapper<UserEntity> {

    @Select("select count(*) from user_info")
    Integer count();

}
