package com.chige.dynamicds.ds;

import com.chige.dynamicds.config.DynamicDataSourceContextHolder;
import com.chige.dynamicds.provider.DynamicDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyc
 * @date 2023/3/2
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    DynamicDataSourceProvider dynamicDataSourceProvider;

    public DynamicDataSource(DynamicDataSourceProvider dataSourceProvider) {
        this.dynamicDataSourceProvider = dataSourceProvider;
        Map<String, DataSource> dataSourceMap = dataSourceProvider.loadDataSources();
        Map<Object, Object> targetDataSources = new HashMap<>(dataSourceMap);
        // 设置当前所有的数据源
        super.setTargetDataSources(targetDataSources);
        // 设置默认数据源
        super.setDefaultTargetDataSource(dataSourceMap.get(DynamicDataSourceProvider.DEFAULT_DATASOURCE));
        super.afterPropertiesSet();
    }


    /**
     * 当需要使用数据源的时候，系统会自动调用该方法，获取当前数据源的标记，如 master 或者 slave 或者其他，
     * 拿到标记之后，就可以据此获取到一个数据源了。
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
