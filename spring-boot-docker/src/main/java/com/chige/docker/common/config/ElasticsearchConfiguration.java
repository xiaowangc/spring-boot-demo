//package com.chige.docker.common.config;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
///**
// * @author wangyc
// * @date 2022/1/12
// */
//
//@Configuration
//public class ElasticsearchConfiguration {
//    @Value("${elasticsearch.servers}")
//    private String servers;
//    @Value("${elasticsearch.connectTimeout}")
//    private int connectTimeout;
//    @Value("${elasticsearch.socketTimeout}")
//    private int socketTimeout;
//    @Value("${elasticsearch.connectRequestTimeout}")
//    private int connectRequestTimeout;
//    @Value("${elasticsearch.maxConnectNum}")
//    private int maxConnectNum;
//    @Value("${elasticsearch.maxConnectPerRoute}")
//    private int maxConnectPerRoute;
//    @Bean
//    public RestClientBuilder restClientBuilder() {
//        String[] serverArray = servers.split(",");
//        HttpHost[] hosts = new HttpHost[serverArray.length];
//        for (int i = 0; i < hosts.length; i++) {
//            String serverIp = serverArray[i];
//            hosts[i] = makeHttpHost(serverIp);
//        }
//        RestClientBuilder restClientBuilder = RestClient.builder(hosts);
//        // 异步连接延时配置
//        restClientBuilder.setRequestConfigCallback(requestConfigCallback -> {
//           requestConfigCallback.setConnectionRequestTimeout(connectRequestTimeout);
//           requestConfigCallback.setSocketTimeout(socketTimeout);
//           requestConfigCallback.setConnectTimeout(connectTimeout);
//           return requestConfigCallback;
//        });
//        // 异步连接数配置
//        restClientBuilder.setHttpClientConfigCallback(httpAsyncClientBuilder ->{
//           httpAsyncClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
//           httpAsyncClientBuilder.setMaxConnTotal(maxConnectNum);
//           return httpAsyncClientBuilder;
//        });
//
//        return restClientBuilder;
//    }
//    private HttpHost makeHttpHost(String servers) {
//        String[] ipPort = servers.split(":");
//        String ip = ipPort[0];
//        Integer port = Integer.parseInt(ipPort[1]);
//        return new HttpHost(ip, port, "http");
//    }
//
//    @Bean
//    public RestHighLevelClient restHighLevelClient(@Autowired RestClientBuilder restClientBuilder) {
//        return new RestHighLevelClient(restClientBuilder);
//    }
//
//}
