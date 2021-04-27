package com.chige.listDemo.controller;

import com.chige.domain.RedPacketRequest;
import com.chige.listDemo.service.RedpacketService;
import com.chige.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 小王
 * 高并发抢红包技术方案：
 *      1、发红包-红包随机金额实现，使用list列表存放生成的每个随机红包金额
 *      2、拆红包和收红包
 */
@Api(tags = "高并发抢红包功能")
@Slf4j
@RestController("/list/redpacket")
public class RedpacketController {

    @Autowired
    private RedpacketService service;
    @ApiOperation("发红包")
    @PostMapping("/set")
    public Response setPacket(@RequestBody RedPacketRequest redPacketRequest) {
        long id = service.setPacket(redPacketRequest);

        return Response.ok().data("id",id);
    }
    @ApiOperation("抢红包接口")
    @GetMapping("/rob")
    public Response robPacket(long redId,long userId) {
        Integer redMoney = service.getOneRed(redId,userId);
        return Response.ok().data("redMoney",redMoney);
    }

}
