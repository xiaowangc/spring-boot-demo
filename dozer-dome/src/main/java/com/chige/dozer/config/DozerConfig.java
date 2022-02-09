package com.chige.dozer.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wangyc
 * @date 2022/1/25
 */
@Configuration
public class DozerConfig {

    public DozerBeanMapper dozer() {
        List<String> mapperFile = Collections.singletonList("dozer/dozer-mapping.xml");
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mapperFile);
        return dozerBeanMapper;
    }


}
