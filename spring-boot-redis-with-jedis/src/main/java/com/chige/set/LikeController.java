package com.chige.set;

import com.chige.redistemplate.model.User;
import com.chige.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "高并发实现点赞功能")
@Slf4j
@RestController
public class LikeController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String LIKE_KEY = "redis:like";

    /**
     *  点赞功能的技术实现：
     *  1、redis数据类型-set；以笔记的点赞场景为例，redis的key需要保证唯一，可以
     *      定义为（点赞前缀 + 笔记id）作为某篇笔记的点赞缓存key。值为点赞的用户id
     *  2、统计笔记点赞数据的命令：scard key
     *  3、新增点赞：sadd redis:like:1 100  取消点赞：srem redis:like:1 100
     *  4、判断用户是否点赞过该笔记：sismember redis:like:1 100
     */
    @ApiOperation("新增点赞")
    @RequestMapping("/like")
    public Response like(@RequestBody LikeRequest likeRequest) {
        redisTemplate.opsForSet().add(LIKE_KEY + likeRequest.getNoteId(),likeRequest.getUserId());
        return Response.ok();
    }
    @ApiOperation("取消点赞")
    @RequestMapping("/unLike")
    public Response unLike(@RequestBody LikeRequest likeRequest) {
        redisTemplate.opsForSet().remove(LIKE_KEY + likeRequest.getNoteId(),likeRequest.getUserId());
        return Response.ok();
    }
    @ApiOperation("判断用户是否点赞笔记")
    @RequestMapping("/ismebmer")
    public Response isMember(@RequestBody LikeRequest likeRequest) {
        redisTemplate.opsForSet().isMember(LIKE_KEY+likeRequest.getNoteId(),likeRequest.getUserId());
        return Response.ok();
    }
}
