package com.chige.tim.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author wangyc
 * @Description 腾讯云Im发送消息回调包 https://cloud.tencent.com/document/product/269/2716
 * @Date 2024/8/3 14:54
 */
@Data
public class TimMsgReceiveRecallDTO {

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
     * 消息序列号，用于标记该条消息（32位无符号整数）
     */
    @JsonProperty("MsgSeq")
    private Integer msgSeq;

    /**
     * 消息随机数，用于标记该条消息（32位无符号整数）
     */
    @JsonProperty("MsgRandom")
    private Integer msgRandom;

    /**
     * 消息的发送时间戳，单位为秒
     * 单聊消息优先使用 MsgTime 进行排序，同一秒发送的消息则按 MsgSeq 排序，MsgSeq 值越大消息越靠后
     */
    @JsonProperty("MsgTime")
    private Integer msgTime;

    /**
     * 该条消息的唯一标识，可根据该标识进行
     */
    @JsonProperty("MsgKey")
    private String msgKey;

    /**
     * 该条消息在客户端唯一标识。
     */
    @JsonProperty("MsgId")
    private String msgId;

    /**
     * 是否仅发送给在线用户标识。1代表仅发送给在线用户，否则为0
     */
    @JsonProperty("OnlineOnlyFlag")
    private Integer onlineOnlyFlag;

    /**
     * 该条消息的发送结果，0表示发送成功，非0表示发送失败
     */
    @JsonProperty("SendMsgResult")
    private Integer sendMsgResult;

    /**
     * 该条消息下发失败的错误信息，若消息发送成功，则为"send msg succeed"
     */
    @JsonProperty("ErrorInfo")
    private String errorInfo;

    /**
     * 消息体
     */
    @JsonProperty("MsgBody")
    private List<Object> msgBodyArray;

    /**
     * 消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）
     */
    @JsonProperty("CloudCustomData")
    private String cloudCustomerData;

    /**
     * 事件触发的毫秒级别时间戳
     */
    @JsonProperty("EventTime")
    private Integer eventTime;

}
