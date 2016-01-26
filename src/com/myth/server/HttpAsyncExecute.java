package com.myth.server;

import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;

import java.io.IOException;

/**
 * Created by mitesh on 26/01/16.
 */
class HttpAsyncExecute {
    HttpRequestClient.HttpObject httpObject;
    CloseableHttpAsyncClient client;

    public static HttpAsyncExecute Builder(HttpRequestClient.HttpObject httpObject) {
        return new HttpAsyncExecute(httpObject);
    }

    private HttpAsyncExecute(HttpRequestClient.HttpObject httpObject) {
        this.httpObject = httpObject;
        this.client = getASyncClient(httpObject.baseUrl);
    }

    private CloseableHttpAsyncClient getASyncClient(String url){
        return CustomAsyncClientBuilder.Builder().build();
    }

    public void execute() {
        client.start();
        client.execute(this.httpObject.request, new FutureCallback<HttpResponse>() {
            @Override
            public void failed(Exception e) {
                HttpAsyncExecute.this.httpObject.responseCallbackHandler.failed(e);
                close();
            }

            @Override
            public void completed(HttpResponse resp) {
                HttpAsyncExecute.this.httpObject.responseCallbackHandler.success(resp, HttpAsyncExecute.this.httpObject.encoding);
                close();
            }
            @Override
            public void cancelled() {
                HttpAsyncExecute.this.httpObject.responseCallbackHandler.cancelled();
                close();
            }
        });
    }

    private void close() {
        try {
            client.close();
        } catch (IOException e) {
        }
    }
}
