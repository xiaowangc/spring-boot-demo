package com.chige.statemachine.pay.common.event;

/** 订单状态变更事件
 * @author wangyc
 * @date 2023/6/3
 */
public enum OrderStatusChangeEvent {

    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED


    ;

}
