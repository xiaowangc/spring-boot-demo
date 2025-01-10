package com.chige.statemachine;

/**
 * @author wangyc
 * @date 2023/6/3
 */
public enum OrderStateMachine {

    DISPATCH {
        @Override
        public OrderStateMachine nextState() {
            return WAI_DELIVER;
        }
        @Override
        public OrderStateMachine preState() {
            return this;
        }
    },

    WAI_DELIVER {
        @Override
        public OrderStateMachine nextState() {
            return DELIVER;
        }
        @Override
        public OrderStateMachine preState() {
            return DISPATCH;
        }
    },

    DELIVER {
        @Override
        public OrderStateMachine nextState() {
            return FINISH;
        }
        @Override
        public OrderStateMachine preState() {
            return WAI_DELIVER;
        }
    },

    FINISH {
        @Override
        public OrderStateMachine nextState() {
            return this;
        }
        @Override
        public OrderStateMachine preState() {
            return DELIVER;
        }
    }


    ;


    /**
     * 下个状态
     * @return
     */
    public abstract OrderStateMachine nextState();

    /**
     * 上个状态
     * @return
     */
    public abstract OrderStateMachine preState();


}
