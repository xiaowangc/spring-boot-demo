package com.chige.tim.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author wangyc
 * @Description 腾讯云Im消息撤回回调包 https://cloud.tencent.com/document/product/269/61697
 * @Date 2024/8/3 14:54
 */
@Data
public class TimMsgWithdrawRecallDTO {

    /**
     * 回调命令
     * {@link com.jk160.hospital.apaas.commons.enums.TencentIMCallbackCommandEnum}
     */
    @JsonProperty("CallbackCommand")
    private String callbackCommand;

    /**
     * 消息发送者 UserID
     */
    @JsonProperty("From_Account")
    private String fromAccount;

    /**
     * 消息接收者 UserID
     */
    @JsonProperty("To_Account")
    private String toAccount;

    /**
     * 该条消息的唯一标识
     */
    @JsonProperty("MsgKey")
    private String msgKey;

    /**
     * 事件触发的毫秒级别时间戳
     */
    @JsonProperty("EventTime")
    private Integer eventTime;

}
