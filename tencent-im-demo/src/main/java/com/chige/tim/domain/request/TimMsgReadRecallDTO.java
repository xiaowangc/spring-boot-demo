package com.chige.tim.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author wangyc
 * @Description 腾讯云Im已读消息上报 https://cloud.tencent.com/document/product/269/61696
 * @Date 2024/8/3 14:54
 */
@Data
public class TimMsgReadRecallDTO {

    /**
     * 回调命令
     * {@link com.jk160.hospital.apaas.commons.enums.TencentIMCallbackCommandEnum}
     */
    @JsonProperty("CallbackCommand")
    private String callbackCommand;

    /**
     * 已读上报方 UserID
     */
    @JsonProperty("Report_Account")
    private String reportAccount;

    /**
     * 会话对端 UserID
     */
    @JsonProperty("Peer_Account")
    private String peerAccount;

    /**
     * 已读时间
     */
    @JsonProperty("LastReadTime")
    private Integer lastReadTime;

    /**
     * 事件触发的毫秒级别时间戳
     */
    @JsonProperty("EventTime")
    private Integer eventTime;

}
