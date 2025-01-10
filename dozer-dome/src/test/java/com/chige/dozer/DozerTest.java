package com.chige.dozer;

import cn.hutool.json.JSONUtil;
import com.chige.dozer.config.DozerConverterName;
import com.chige.dozer.domain.Person;
import com.chige.dozer.domain.User;
import com.chige.dozer.util.DozerConverter;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyc
 * @date 2023/8/1
 */
@SpringBootTest(classes = DozerDemoApp.class)
public class DozerTest {

    private DozerConverter mapDozerConverter = new DozerConverter(DozerConverterName.MAP_CONFIG_PERSON);
    private DozerConverter listDozerConverter = new DozerConverter(DozerConverterName.LiST_CONFIG_PERSON);



    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", 1);
        map.put("id_type", 2);
        map.put("true_name", "忘咯");
        map.put("sex", 1);

        Person person = mapDozerConverter.convertor(map, Person.class);
        System.out.println(JSONUtil.toJsonStr(person));
    }

    @Test
    public void testPersonToUser() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,1,"af",1));
        personList.add(new Person(2,1,"bf",2));

        List<User> convertor = listDozerConverter.convertor(personList, User.class);
        System.out.println(JSONUtil.toJsonStr(convertor));
    }

    @Test
    public void testUserToPerson() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1",1,"af","1"));
        userList.add(new User("2",1,"bf","2"));

        List<Person> convertor = listDozerConverter.convertor(userList, Person.class);
        System.out.println(JSONUtil.toJsonStr(convertor));
    }

}
