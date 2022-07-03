package com.chige.springannotation.configuration;

import com.chige.springannotation.validation.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/** 读取配置文件属性的配置类
 * @author wangyc
 * @date 2022/7/3
 */
@ConfigurationProperties(prefix = "read.properties")
public class HelloProperties {

    private String name;
    private Integer age;
    private List<String> friends;
    private Map<String, String> map;
    private Person person;

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

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "HelloProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + friends +
                ", map=" + map +
                ", person=" + person +
                '}';
    }
}
