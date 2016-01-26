package com.myth.server;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;

/**
 * Created by mitesh on 25/01/16.
 */
class CustomAsyncClientBuilder extends HttpAsyncClientBuilder {

    public static CustomAsyncClientBuilder Builder() {
        return new CustomAsyncClientBuilder();
    }

    public CustomAsyncClientBuilder timeout(int timeout){
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(timeout)
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        return (CustomAsyncClientBuilder) this.setDefaultRequestConfig(config);
    }
}
