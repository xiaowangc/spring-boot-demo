package com.chige.dozer.domain;

/**
 * @author wangyc
 * @date 2022/1/25
 */
public class Person extends BaseEntity {

    private Integer userId;
    private Integer idType;
    private String trueName;
    private Integer sex;

    public Person() {

    }

    public Person(Integer userId, Integer idType, String trueName, Integer sex) {
        this.userId = userId;
        this.idType = idType;
        this.trueName = trueName;
        this.sex = sex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
