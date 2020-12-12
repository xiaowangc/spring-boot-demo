package com.chige.springbootkafka;

import com.chige.springbootkafka.domain.Person;
import com.chige.springbootkafka.util.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJacksonUtil {



    @Test
    public void test(){
        Person person = new Person("小黑",15);
        String s = JacksonUtil.objectToString(person);
        String s1 = JacksonUtil.objectToJson(person);
        System.out.println(s);
        System.out.println(s1);

    }

}
