package com.chige.statemachine.pay.common.model;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;

/**
 * @author wangyc
 * @date 2023/6/3
 */
public class Order {

    private Long id;
    // 订单号
    private String orderNo;
    // 订单状态
    private OrderStatus orderStatus;

    @Override
    public String toString() {
        return "订单信息:{" +
                "订单号=" + orderNo +
                ", 订单状态=" + orderStatus +
                '}';
    }
    

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
