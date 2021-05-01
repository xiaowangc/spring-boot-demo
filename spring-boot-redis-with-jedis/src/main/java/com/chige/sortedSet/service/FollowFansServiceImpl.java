package com.chige.sortedSet.service;

import com.chige.redistemplate.model.LinkPersonBO;
import com.chige.redistemplate.model.PersonBO;
import com.chige.redistemplate.model.RelationListRequest;
import com.chige.redistemplate.model.RelationListUserInfo;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class FollowFansServiceImpl {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     *  获取我的关注列表
     * @return
     */
    public List<RelationListUserInfo> myFollowList() {
        List<RelationListUserInfo> list = new LinkedList<>();

        return list;
    }

    /**
     *  获取我的粉丝列表
     * @return
     */
    public List<RelationListUserInfo> myFansList() {
        List<RelationListUserInfo> list = new LinkedList<>();
        return list;
    }

    /**
     *  获取Ta的关注列表
     * @return
     */
    public List<RelationListUserInfo> taFollowList() {
        List<RelationListUserInfo> list = new LinkedList<>();
        return list;
    }
    /**
     *  获取Ta的粉丝列表
     * @return
     */
    public List<RelationListUserInfo> taFansList() {
        List<RelationListUserInfo> list = new LinkedList<>();
        return list;
    }

    /**
     *  查看用户的关注数量和粉丝数
     */
    public Map<String, Integer> followFansNum(PersonBO personBO) {

        return null;
    }


    public Integer addFollow(LinkPersonBO linkPersonBO) {
        return null;
    }

    public Integer cancelFollow(LinkPersonBO linkPersonBO) {
        return null;
    }

    /**
     *  查询用户之间的关注状态
     * @return 1未关注 2回关 3已关注 4互关
     */
    public Integer followStatus(LinkPersonBO linkPersonBO) {
        return 0;
    }
}
