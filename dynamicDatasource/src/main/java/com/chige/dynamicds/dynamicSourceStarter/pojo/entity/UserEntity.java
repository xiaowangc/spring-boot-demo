package com.chige.dynamicds.dynamicSourceStarter.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@Data
@TableName(value = "user_info")
public class UserEntity {

    @TableId(value = "id")
    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
