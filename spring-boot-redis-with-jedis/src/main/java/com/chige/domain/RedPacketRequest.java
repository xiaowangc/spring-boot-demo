package com.chige.domain;

import lombok.Data;

@Data
public class RedPacketRequest {

    /**
     *  总金额
     */
    private Integer money;
    /**
     *  红包数量
     */
    private Integer num;

}
