package com.chige.dozer.domain;

/**
 * @author wangyc
 * @date 2023/8/1
 */
public class User {

    private String userId;
    private Integer idType;
    private String trueName;
    private String gender;

    public User() {
    }

    public User(String userId, Integer idType, String trueName, String gender) {
        this.userId = userId;
        this.idType = idType;
        this.trueName = trueName;
        this.gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
