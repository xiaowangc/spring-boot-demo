package com.chige.xxl.demo.task;

import cn.hutool.json.JSONUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author wangyc
 * @date 2021/7/18
 */
@Service
public class CountTask {

    private static Logger log = LoggerFactory.getLogger(CountTask.class);
    private Integer allDoctor = 2000;

    @XxlJob("countTask")
    public ReturnT<String> countTask(String param) {
        // 分片参数

        log.info("测试开始。。。");
        return new ReturnT<>("hello");
    }

    @XxlJob("doctorFansTest")
    public ReturnT<String> doctorFansTest(String param) {
        Person person = JSONUtil.toBean(param, Person.class);
        log.info("入参为：{},name={},age={}", param,person.getName(),person.getAge());
        return ReturnT.SUCCESS;
    }

    @XxlJob("failTest")
    public ReturnT<String> fail(String param) {
        log.info("执行结果为失败的测试");
        return IJobHandler.FAIL;
    }
    @XxlJob("exceptionTest")
    public ReturnT<String> exceptionTest(String param) {
        try {
            throw new RuntimeException("测试定时任务运行时异常。");
        }catch (Exception e) {
            return ReturnT.FAIL;
        }
    }

    public class Person{
        private String name;
        private Integer age;
        public Person(){}
        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
