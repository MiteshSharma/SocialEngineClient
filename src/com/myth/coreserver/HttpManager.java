package com.myth.coreserver;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by mitesh on 26/01/16.
 */
public class HttpManager {

    private HttpRequestClient httpRequestClient;

    public HttpManager() {
        httpRequestClient = new HttpRequestClient();
    }

    public void get(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) {
        try {
            httpRequestClient.get(baseUrl, paramMap, handler, isAsync);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void post(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) {
        try {
            httpRequestClient.post(baseUrl, paramMap, handler, isAsync);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void put(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) {
        try {
            httpRequestClient.put(baseUrl, paramMap, handler, isAsync);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void delete(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) {
        try {
            httpRequestClient.delete(baseUrl, paramMap, handler, isAsync);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void send(String baseUrl, HttpRequestClient.HttpMethodType httpMethod, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) {
        try {
            httpRequestClient.send(baseUrl, httpMethod, paramMap, handler, isAsync);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setRequestInterceptor(RequestInterceptor requestInterceptor) {
        this.httpRequestClient.setRequestInterceptor(requestInterceptor);
    }
}