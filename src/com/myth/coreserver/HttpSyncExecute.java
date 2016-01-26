package com.myth.coreserver;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

/**
 * Created by mitesh on 26/01/16.
 */
class HttpSyncExecute {

    HttpRequestClient.HttpObject httpObject;
    HttpClient client;

    public static HttpSyncExecute Builder(HttpRequestClient.HttpObject httpObject) {
        return new HttpSyncExecute(httpObject);
    }

    private HttpSyncExecute(HttpRequestClient.HttpObject httpObject) {
        this.httpObject = httpObject;
        this.client = getSyncClient(httpObject.baseUrl);
    }

    private HttpClient getSyncClient(String url)  {
        return CustomSyncClientBuilder.Builder().build();
    }

    public void execute() {
        HttpResponse response =null;
        try {
            response = this.client.execute(this.httpObject.request);
            this.httpObject.responseCallbackHandler.success(response, this.httpObject.encoding);
        } catch (ParseException | IOException e) {
        } finally {
            try {
                if(response == null) return;
                if(CloseableHttpResponse.class.isAssignableFrom(response.getClass())){
                    ((CloseableHttpResponse)response).close();
                }
            } catch (IOException e) {
            };
        }
    }
}
