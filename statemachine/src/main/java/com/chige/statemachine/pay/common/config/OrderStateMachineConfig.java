package com.chige.statemachine.pay.common.config;

import com.chige.statemachine.pay.common.event.OrderStatusChangeEvent;
import com.chige.statemachine.pay.common.model.Order;
import com.chige.statemachine.pay.common.model.OrderStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

/**
 * 订单状态机配置
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {

    /**
     * 配置状态
     * @param config
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> config) throws Exception {
        config.withStates()
                // 定义初始状态
                .initial(OrderStatus.WAIT_PAYMENT)
                // 定义所有状态集合
                .states(EnumSet.allOf(OrderStatus.class));
    }

    /**
     * 配置状态转换事件关系
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitionConfigurer) throws Exception {
        transitionConfigurer
                // 待支付 -> 待发货
                .withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                // 待发货 -> 待收货
                .withExternal().source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                // 待收货 -> 完成
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }

    /** todo
     * 持久化配置
     * 实际使用中，可以配合redis等，进行持久化操作
     */
    @Bean
    public DefaultStateMachinePersister persistent() {
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object, Object, Order>() {
            @Override
            public void write(StateMachineContext<Object, Object> context, Order order) throws Exception {
                //此处并没有进行持久化操作
            }

            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                //此处直接获取order中的状态，其实并没有进行持久化读取操作
                return new DefaultStateMachineContext(order.getOrderStatus(), null, null, null);
            }
        });
    }


}
