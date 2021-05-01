package com.chige.sortedSet;

import com.chige.redistemplate.model.LinkPersonBO;
import com.chige.redistemplate.model.PersonBO;
import com.chige.redistemplate.model.RelationListRequest;
import com.chige.redistemplate.model.RelationListUserInfo;
import com.chige.response.Response;
import com.chige.sortedSet.service.FollowFansServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = "关注、粉丝列表")
@Slf4j
@RestController
@RequestMapping("/relation")
public class FollowFansController {

    private static final String FOLLOW_FANS_LIST_KEY = "follow";
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private FollowFansServiceImpl followFansService;

    /**
     *  关注、粉丝列表技术实现：redis数据结构采用sortedSet实现
     *  1、特点：关注列表需要保证不重复且需要按最新关注倒序排列
     *  2、redis的key定义：
     * @param request
     * @return
     */
    @ApiOperation("查看用户的关注/粉丝列表")
    @RequestMapping("/showByListType")
    public Response showByListType(@RequestBody RelationListRequest request) {
        List<RelationListUserInfo> result = null;
        switch (request.getListType()) {
            case 1: result = followFansService.myFollowList();
            case 2: result = followFansService.myFansList();
            case 3: result = followFansService.taFollowList();
            case 4: result = followFansService.taFansList();
            default:result = new ArrayList<>();
        }
        return Response.ok().data("list",result);
    }
    @ApiOperation("查看我的关注数量和粉丝数量")
    @RequestMapping("/followFansNum")
    public Response followFansRequest(@RequestBody PersonBO personBO) {
        Map<String,Integer> map = followFansService.followFansNum(personBO);

        return Response.ok().data("followFans",map);
    }

    /**
     * @return 返回关注状态
     */
    @ApiOperation("新增关注")
    @RequestMapping("/addFollow")
    public Response addFollow(@RequestBody LinkPersonBO linkPersonBO) {
        Integer status = followFansService.addFollow(linkPersonBO);
        return Response.ok().data("followStatus",status);
    }
    /**
     * @return 返回关注状态
     */
    @ApiOperation("取消关注")
    @RequestMapping("/cancelFollow")
    public Response cancelFollow(@RequestBody LinkPersonBO linkPersonBO) {
        Integer status = followFansService.cancelFollow(linkPersonBO);
        return Response.ok().data("followStatus",status);
    }

    /**
     * @return 返回关注状态
     */
    @ApiOperation("查询用户之间的关注状态")
    @RequestMapping("/status")
    public Response followStatus(@RequestBody LinkPersonBO linkPersonBO) {
        Integer status = followFansService.followStatus(linkPersonBO);
        return Response.ok().data("followStatus",status);
    }
}
