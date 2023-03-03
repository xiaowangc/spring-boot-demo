package com.chige.dynamicds.provider;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author wangyc
 * @date 2023/3/2
 */

public interface DynamicDataSourceProvider {

    String DEFAULT_DATASOURCE = "master";

    Map<String, DataSource> loadDataSources();
}
