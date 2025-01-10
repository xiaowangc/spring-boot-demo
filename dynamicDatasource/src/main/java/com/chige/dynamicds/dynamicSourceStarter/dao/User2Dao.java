package com.chige.dynamicds.dynamicSourceStarter.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chige.dynamicds.dynamicSourceStarter.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@Mapper
@DS(value = "db2")
public interface User2Dao extends BaseMapper<UserEntity> {

    @Select("select count(*) from user_info where age >= #{userAge}")
    Integer countByAge(@Param("userAge") Integer age);

    @Select("select * from user_info where name = #{name}")
    UserEntity queryByName(@Param("name") String name);

}
