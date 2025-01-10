package com.chige.statemachine;

import java.math.BigDecimal;

/**
 * @author wangyc
 * @date 2023/6/3
 */
public class Order {

    private OrderStateMachine orderStateMachine = OrderStateMachine.DISPATCH;
    private String name;
    private BigDecimal amount;

    public Order nextState() {
        orderStateMachine = this.orderStateMachine.nextState();
        return this;
    }

    public Order preState() {
        this.orderStateMachine = this.orderStateMachine.preState();
        return this;
    }

    public void log() {
        System.out.println(this.orderStateMachine.preState() + "-->" + this.orderStateMachine.name());
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.setAmount(BigDecimal.TEN);
        order.setName("随便");

        order.nextState();
        order.log();

        order.nextState();
        order.log();

        order.nextState();
        order.log();



    }

    public OrderStateMachine getOrderStateMachine() {
        return orderStateMachine;
    }

    public void setOrderStateMachine(OrderStateMachine orderStateMachine) {
        this.orderStateMachine = orderStateMachine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
