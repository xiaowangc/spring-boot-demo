package com.chige.openfeign.config;


import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyc
 * @date 2021/12/2
 */
public class FeignMessageConverter extends MappingJackson2HttpMessageConverter {

    public FeignMessageConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.ALL);
        setSupportedMediaTypes(mediaTypes);
    }
}
