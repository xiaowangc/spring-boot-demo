package com.chige.statemachine.pay.common.listener;

import com.chige.statemachine.pay.common.event.OrderStatusChangeEvent;
import com.chige.statemachine.pay.common.model.Order;
import com.chige.statemachine.pay.common.model.OrderStatus;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

/**
 * 订单状态监听器
 *
 * @author wangyc
 * @date 2023/6/3
 */
@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")
public class OrderStateListenerImpl {

    /**
     * 支付事件/动作发生，触发状态变更
     *
     * @param message
     */
    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public void payTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.WAIT_DELIVER);
        System.out.println("订单号：" + order.getOrderNo() + "支付成功，状态变为待发货");
    }

    /**
     * 发货事件/动作发生，触发状态变更
     * @param message
     */
    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public void deliverTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.WAIT_RECEIVE);
        System.out.println("订单号：" + order.getOrderNo() + "已经发货，状态变为待收货");
    }

    /**
     * 收货事件/动作发生，触发状态变更
     * @param message
     */
    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public void receiveTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.FINISH);
        System.out.println("订单号：" + order.getOrderNo() + "已经收货，状态变为已完成");
    }

//        /**
//         * 支付完成事件/动作发生，触发状态变更
//         * @param message
//         */
//        @OnTransition(source = "WAIT_PAYMENT", target = "FINISH")
//        public void payToFinishTransition(Message<OrderStatusChangeEvent> message) {
//            Order order = (Order) message.getHeaders().get("order");
//            order.setOrderStatus(OrderStatus.FINISH);
//            System.out.println("订单" + order.getOrderNo() + "已经支付，状态变为已完成");
//        }
//
//        /**
//         * 发货完成事件/动作发生，触发状态变更
//         * @param message
//         */
//        @OnTransition(source = "WAIT_DELIVER", target = "FINISH")
//        public void deliverToFinishTransition(Message<OrderStatusChangeEvent> message) {
//            Order order = (Order) message.getHeaders().get("order");
//            order.setOrderStatus(OrderStatus.FINISH);
//            System.out.println("订单" + order.getOrderNo() + "已经发货，状态变为已完成");
//        }
//
//        /**
//         * 收货完成事件/动作发生，触发状态变更
//         * @param message
//         */
//        @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
//        public void receiveToFinishTransition(Message<OrderStatusChangeEvent> message) {
//            Order order = (Order) message.getHeaders().get("order");
//            order.setOrderStatus(OrderStatus.FINISH);
//            System.out.println("订单" + order.getOrderNo() + "已经收货，状态变为已完成");
//        }

}
