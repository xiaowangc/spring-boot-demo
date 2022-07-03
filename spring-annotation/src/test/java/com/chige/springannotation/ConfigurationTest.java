package com.chige.springannotation;

import com.chige.springannotation.configuration.HelloProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wangyc
 * @date 2022/7/3
 */
@SpringBootTest
public class ConfigurationTest {

    @Autowired
    private HelloProperties helloProperties;

    @Test
    public void testReadProperties() {
        System.out.println(helloProperties);
    }
}
