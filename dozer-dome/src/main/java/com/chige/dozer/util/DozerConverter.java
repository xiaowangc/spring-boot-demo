package com.chige.dozer.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linyc
 * @version DozerConverter 2021/1/25 19:51
 */
public class DozerConverter {

    Mapper mapper;

    public DozerConverter(String file) {
        this.mapper = new DozerBeanMapper(Arrays.asList(file));
    }

    public <T, S> T convertor(S source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, clz);
    }

    public <T, S> List<T> convertor(List<S> source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        List<T> list = new ArrayList<>(source.size());
        for (S s : source) {
            list.add(convertor(s, clz));
        }
        return list;
    }
}