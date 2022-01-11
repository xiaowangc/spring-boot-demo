package com.chige.openfeign.config;

import lombok.Data;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * @author dongtf
 */
@Configuration
@Data
public class HttpClientConfig {

    @Value("${http.maxTotal:640}")
    private Integer maxTotal;						//最大连接数

    @Value("${http.defaultMaxPerRoute:320}")
    private Integer defaultMaxPerRoute;				//最大并发链接数

    @Value("${http.connectTimeout:5000}")
    private Integer connectTimeout;					//创建链接的最大时间

    @Value("${http.connectionRequestTimeout:5000}")
    private Integer connectionRequestTimeout;		//链接获取超时时间

    @Value("${http.socketTimeout:5000}")
    private Integer socketTimeout;			  		//数据传输最长时间

/*    @Value("${http.staleConnectionCheckEnabled}")
    private boolean staleConnectionCheckEnabled; 	//提交时检查链接是否可用*/

    @Value("${http.retryCount:1}")
    private Integer retryCount;

    @Value("${http.requestSentRetryEnabled:true}")
    private Boolean requestSentRetryEnabled;

    //定义httpClient链接池
    @Bean(name="httpClientConnectionManager")
    public PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
        // 配置同时支持 HTTP 和 HTPPS
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        manager.setMaxTotal(maxTotal);  //设定最大链接数
        manager.setDefaultMaxPerRoute(defaultMaxPerRoute);  //设定并发链接数
        return manager;
    }

    @Bean()
    public HttpClient httpClient(@Qualifier("httpClientConnectionManager")PoolingHttpClientConnectionManager poolConnManager) {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout).build();
        CloseableHttpClient httpClient = HttpClients.custom()
                // 设置连接池管理
                .setConnectionManager(poolConnManager)
                .setDefaultRequestConfig(config)
                // 设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(retryCount, requestSentRetryEnabled)).build();
        return httpClient;
    }
}
