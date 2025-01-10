package com.chige.statemachine.pay.common.model;

/**
 * @author wangyc
 * @date 2023/6/3
 */
public enum OrderStatus {

    // 待支付，待发货，待收货，已完成
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;


    //待支付-（支付）-待发货-（发货）-待收货-（确认收货）-已完成

}
