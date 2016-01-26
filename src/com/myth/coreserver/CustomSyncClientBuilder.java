package com.myth.coreserver;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Created by mitesh on 25/01/16.
 */
class CustomSyncClientBuilder extends HttpClientBuilder {
    public static CustomSyncClientBuilder Builder() {
        return new CustomSyncClientBuilder();
    }

    public CustomSyncClientBuilder timeout(int timeout){
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(timeout)
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        return (CustomSyncClientBuilder) this.setDefaultRequestConfig(config);
    }
}
