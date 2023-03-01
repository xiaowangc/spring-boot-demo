package com.chige.xxl.demo.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.ShardingUtil;

/**
 * 分片任务
 *
 * @author wangyc
 * @date 2022/10/28
 */
public class ShardingTask {


    @XxlJob("shardingTask")
    public ReturnT<String> shardingTask(String param) {
        int total = ShardingUtil.getShardingVo().getTotal(); //总分片数
        int shardIndex = ShardingUtil.getShardingVo().getIndex(); //分片索引位置
        // 开始id
        long startId;
        // 结束id
        long endId;
        long maxId = getMaxId();
        long ADD_ID = 5000;
        // 执行任务的总次数
        long exeCount = (maxId - 1) / ADD_ID;

        XxlJobLogger.log("maxId={},需要执行的任务总次数为:{}", maxId, exeCount);
        for (long i = 0; i < exeCount; i++) {
            if (shardIndex == i % total) {
                XxlJobLogger.log("第{}片,命中分片开始处理,执行第{}次循环", shardIndex, i);
                startId = i * ADD_ID + 1;
                endId = startId + ADD_ID;

                // todo 执行代码逻辑任务

            } else {
                XxlJobLogger.log("第 {} 片, 忽略,", shardIndex);
            }
        }
        return ReturnT.SUCCESS;
    }

    private Integer getMaxId() {
        // mapper.getMaxId();
        return 0;
    }

}
