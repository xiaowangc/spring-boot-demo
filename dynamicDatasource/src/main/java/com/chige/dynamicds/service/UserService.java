package com.chige.dynamicds.service;

import com.chige.dynamicds.annotation.DataSource;
import com.chige.dynamicds.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyc
 * @date 2023/3/2
 */
@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @DataSource(dataSourceName = "master")
    public Integer getCount() {
        return userMapper.count();
    }

    @DataSource(dataSourceName = "slave")
    public Integer slave() {
        return userMapper.count();
    }

}
