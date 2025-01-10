package com.chige.statemachine.pay.common.service;

import com.chige.statemachine.pay.common.model.Order;

import java.util.Map;

/**
 * @author wangyc
 * @date 2023/6/3
 */
public interface OrderService {
    //创建订单
    Order create();

    //发起支付
    Order pay(String orderNo);

    //订单发货
    Order deliver(String orderNo);

    //订单收货
    Order receive(String orderNo);

    //获取所有订单信息
    Map<String, Order> getOrders();
}
