package com.chige.statemachine;

import com.chige.statemachine.pay.common.App;
import com.chige.statemachine.pay.common.model.Order;
import com.chige.statemachine.pay.common.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author wangyc
 * @date 2023/6/3
 */
@SpringBootTest(classes = App.class)
public class StateMachineTest {

    @Resource(name = "orderService")
    private OrderService orderService;

    @Test
    public void test() {
        Thread.currentThread().setName("主线程");
        Order order = orderService.create();
        Order order1 = orderService.create();
        orderService.pay(order.getOrderNo());
        new Thread("客户线程") {
            @Override
            public void run() {
                orderService.deliver(order.getOrderNo());
                orderService.receive(order.getOrderNo());
            }
        }.start();
        orderService.pay(order1.getOrderNo());
        orderService.deliver(order1.getOrderNo());
        orderService.receive(order1.getOrderNo());
        System.out.println("全部订单状态：" + orderService.getOrders());
    }

}
