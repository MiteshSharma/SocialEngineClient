package com.myth.server;

import org.apache.http.client.methods.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mitesh on 26/01/16.
 */
class HttpRequestClient {

    public void get(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) throws UnsupportedEncodingException {
        this.send(baseUrl, HttpMethodType.GET, paramMap, new HashMap<>(), Charset.defaultCharset().name(), handler, isAsync);
    }

    public void post(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) throws UnsupportedEncodingException {
        this.send(baseUrl, HttpMethodType.POST, paramMap, new HashMap<>(), Charset.defaultCharset().name(), handler, isAsync);
    }

    public void put(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) throws UnsupportedEncodingException {
        this.send(baseUrl, HttpMethodType.PUT, paramMap, new HashMap<>(), Charset.defaultCharset().name(), handler, isAsync);
    }

    public void delete(String baseUrl, Map<String,Object> paramMap, ResponseCallbackHandler handler, boolean isAsync) throws UnsupportedEncodingException {
        this.send(baseUrl, HttpMethodType.DELETE, paramMap, new HashMap<>(), Charset.defaultCharset().name(), handler, isAsync);
    }

    public void send(String baseUrl, HttpMethodType httpMethod,
                     Map<String,Object> paramMap,
                     ResponseCallbackHandler handler, boolean isAsync) throws UnsupportedEncodingException {
        this.send(baseUrl, httpMethod, paramMap, new HashMap<>(), Charset.defaultCharset().name(), handler, isAsync);
    }

    public void send(String baseUrl, HttpMethodType httpMethod,
                     Map<String,Object> paramMap, Map<String,String> headerMap, String encoding,
                     ResponseCallbackHandler handler, boolean isAsync) throws UnsupportedEncodingException {
        HttpRequestBase request = getRequest(baseUrl, httpMethod);

        for (Map.Entry<String, String> headerEntry : headerMap.entrySet()) {
            request.setHeader(headerEntry.getKey(), headerEntry.getValue());
        }

        if(HttpEntityEnclosingRequestBase.class.isAssignableFrom(request.getClass())){
            ((HttpEntityEnclosingRequestBase) request).setEntity(HttpHelper.getHttpEntity(paramMap, encoding));
        }

        execute(request, baseUrl, encoding, handler, isAsync);
    }

    private void execute(HttpRequestBase request, String baseUrl, String encoding, ResponseCallbackHandler responseCallbackHandler, boolean isAsync) {
        if (isAsync) {
            HttpAsyncExecute.Builder(new HttpObject(request, baseUrl, encoding, responseCallbackHandler)).execute();
        } else {
            HttpSyncExecute.Builder(new HttpObject(request, baseUrl, encoding, responseCallbackHandler)).execute();
        }
    }

    private static HttpRequestBase getRequest(String url, HttpMethodType method) {
        HttpRequestBase request = null;
        switch (method) {
            case GET:
                request = new HttpGet(url);
                break;
            case POST:
                request = new HttpPost(url);
                break;
            case PUT:
                request = new HttpPut(url);
                break;
            case DELETE:
                request = new HttpDelete(url);
                break;
            default:
                request = new HttpPost(url);
                break;
        }
        return request;
    }

    public static class HttpObject {
        HttpRequestBase request;
        String baseUrl;
        String encoding;
        ResponseCallbackHandler responseCallbackHandler;

        public HttpObject(HttpRequestBase request, String baseUrl, String encoding, ResponseCallbackHandler responseCallbackHandler) {
            this.request = request;
            this.baseUrl = baseUrl;
            this.encoding = encoding;
            this.responseCallbackHandler = responseCallbackHandler;
        }
    }

    public enum HttpMethodType {
        GET,
        POST,
        PUT,
        DELETE;

    }
}
