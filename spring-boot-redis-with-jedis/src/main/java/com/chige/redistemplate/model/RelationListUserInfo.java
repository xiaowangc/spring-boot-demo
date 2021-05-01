package com.chige.redistemplate.model;

import lombok.Data;

@Data
public class RelationListUserInfo extends PersonBO{
    /**
     *  粉丝量
      */
    private Integer fansNum;
    /**
     * 关注状态 1未关注 2回关 3已关注 4互关
     */
    private Integer followStatus;

}
