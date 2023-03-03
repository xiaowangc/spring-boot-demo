package com.chige.configLoad;

import com.chige.configLoad.config.AllConfig;
import com.chige.configLoad.config.PojoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@SpringBootTest
public class ConfigTest {

    @Autowired
    private AllConfig allConfig;
    @Autowired
    private AllConfig.Config config;
    @Autowired
    private PojoConfig.User pojoConfigUser;

    @Test
    public void testBasic() {
        allConfig.basicConfig.stdout();
        System.out.println(allConfig.mapConfig.getMap());
        System.out.println(allConfig.mapConfig.getDoubleMap());
        System.out.println(allConfig.listConfig.getList());
        System.out.println(allConfig.listConfig.getList2());
        System.out.println(allConfig.listConfig.getList3());
    }

    @Test
    public void testConfig() {
        System.out.println(config.toString());
    }
    @Test
    public void testPojoConfig() {
        System.out.println(pojoConfigUser.toString());
    }
}
