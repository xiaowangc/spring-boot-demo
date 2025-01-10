package com.chige.tim.controller;

import cn.hutool.json.JSONUtil;
import com.chige.tim.domain.reponse.Response;
import com.chige.tim.domain.request.TimMsgReadRecallDTO;
import com.chige.tim.domain.request.TimMsgReceiveRecallDTO;
import com.chige.tim.domain.request.TimMsgWithdrawRecallDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wangyc
 * @Description im统一处理回调数据
 * @Date 2024/8/1 17:09
 */
@Slf4j
@RequestMapping("/im/recall")
@RestController
public class IMRecallController {

    /**
     * todo 需要校验腾讯云im请求过来的数据，防止出现中间人攻击
     */

    @PostMapping("/pub/v1/tim/msg/receive")
    public Response<String> receiveTimMsg(@RequestParam("SdkAppid") String sdkAppId,
                                   @RequestParam("CallbackCommand") String callbackCommand,
                                   @RequestParam("contenttype") String contentType,
                                   @RequestParam("ClientIP") String clientIp,
                                   @RequestParam("OptPlatform") String optPlatform,
                                   @RequestBody TimMsgReceiveRecallDTO timMsgReceiveRecallDTO) {
        log.info("收到回调信息：发送消息={}", JSONUtil.toJsonStr(timMsgReceiveRecallDTO));
        return Response.ok();
    }

    @GetMapping("/pub/v1/tim/msg/readyRead")
    public Response<String> readyRead(@RequestParam("SdkAppid") String sdkAppId,
                               @RequestParam("CallbackCommand") String callbackCommand,
                               @RequestParam("contenttype") String contentType,
                               @RequestParam("ClientIP") String clientIp,
                               @RequestParam("OptPlatform") String optPlatform,
                               @RequestBody TimMsgReadRecallDTO timMsgReadRecallDTO) {
        //收到此回调请求，已读数置0
        log.info("收到回调信息：已读-{}", JSONUtil.toJsonStr(timMsgReadRecallDTO));
        return Response.ok();
    }

    @GetMapping("/pub/v1/tim/msg/withdraw")
    public Response<String> msgCancel(@RequestParam("SdkAppid") String sdkAppId,
                                      @RequestParam("CallbackCommand") String callbackCommand,
                                      @RequestParam("contenttype") String contentType,
                                      @RequestParam("ClientIP") String clientIp,
                                      @RequestParam("OptPlatform") String optPlatform,
                                      @RequestBody TimMsgWithdrawRecallDTO timMsgWithdrawRecallDTO) {
        log.info("收到回调信息：撤回={}", JSONUtil.toJsonStr(timMsgWithdrawRecallDTO));

        return Response.ok();
    }


}
