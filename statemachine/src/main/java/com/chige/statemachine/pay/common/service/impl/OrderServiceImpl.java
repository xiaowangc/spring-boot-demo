package com.chige.statemachine.pay.common.service.impl;

import cn.hutool.core.date.DateUtil;
import com.chige.statemachine.pay.common.event.OrderStatusChangeEvent;
import com.chige.statemachine.pay.common.model.Order;
import com.chige.statemachine.pay.common.model.OrderStatus;
import com.chige.statemachine.pay.common.service.OrderService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wangyc
 * @date 2023/6/3
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;
    @Autowired
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persistent;

    private AtomicLong id = new AtomicLong(1);
    private Map<String, Order> orders = new HashMap<>();

    @Override
    public Order create() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.WAIT_PAYMENT);
        order.setId(id.incrementAndGet());
        order.setOrderNo(DateUtil.format(LocalDateTime.now(), "yyyyMMdd") + id);
        orders.put(order.getOrderNo(), order);
        return order;
    }

    @Override
    public Order pay(String orderNo) {
        Order order = getOrders().get(orderNo);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试支付，订单号：" + orderNo);

        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 支付失败, 状态异常，订单号：" + orderNo);
        }
        return orders.get(orderNo);
    }

    @Override
    public Order deliver(String orderNo) {
        Order order = orders.get(orderNo);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试发货，订单号：" + orderNo);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build(), orders.get(orderNo))) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 发货失败，状态异常，订单号：" + orderNo);
        }
        return orders.get(orderNo);
    }

    @Override
    public Order receive(String orderNo) {
        Order order = orders.get(orderNo);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试收货，订单号：" + orderNo);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build(), orders.get(orderNo))) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 收货失败，状态异常，订单号：" + orderNo);
        }
        return orders.get(orderNo);
    }

    @Override
    public Map<String, Order> getOrders() {
        return orders;
    }

    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {
        boolean result = false;
        try {
            orderStateMachine.start();
            //尝试恢复状态机状态
            persistent.restore(orderStateMachine, order);
            //添加延迟用于线程安全测试
            Thread.sleep(1000);
            result = orderStateMachine.sendEvent(message);
            //持久化状态机状态
            persistent.persist(orderStateMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStateMachine.stop();
        }
        return result;
    }

}
