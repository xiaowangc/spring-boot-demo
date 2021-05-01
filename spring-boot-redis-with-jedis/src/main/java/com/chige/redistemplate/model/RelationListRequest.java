package com.chige.redistemplate.model;

import lombok.Data;

@Data
public class RelationListRequest extends PersonBO {
    /**
     *  被关注用户id
     */
    private String linkPersonId;

    private Integer linkIdType;
    /**
     *  关系列表：1我的关注列表 2我的粉丝列表 3他的关注列表 4他的粉丝列表
     */
    private Integer listType;
    /**
     *  关系类型 1关注 。。。
     */
    private Integer relationType;
}
