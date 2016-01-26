package com.myth.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.lang.reflect.Type;

/**
 * Created by mitesh on 26/01/16.
 */
public class ResponseCallbackHandler {
    private Type type;
    private IResponseListener listener;
    private static final String RETURN_TYPE = "application/json";
    private Gson gson;

    public ResponseCallbackHandler(IResponseListener listener, Type type) {
        this.type = type;
        this.listener = listener;
        this.gson = new GsonBuilder().create();
    }

    public ResponseCallbackHandler(IResponseListener listener, Type type, Gson gson) {
        this.type = type;
        this.listener = listener;
        this.gson = gson;
    }

    public void success(HttpResponse response, String encoding) {
        String resultString="";
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                final InputStream inputStream = entity.getContent();
                try {
                    final StringBuilder sb = new StringBuilder();
                    final char[] tmp = new char[1024];
                    final Reader reader = new InputStreamReader(inputStream,encoding);
                    int l;
                    while ((l = reader.read(tmp)) != -1) {
                        sb.append(tmp, 0, l);
                    }
                    resultString = sb.toString();
                } finally {
                    inputStream.close();
                    EntityUtils.consume(entity);
                }
            }
        } catch (ParseException | IOException e) {
        }

        Object object = null;
        try {
            object = this.gson.fromJson(resultString, type);
        } catch (JsonSyntaxException ex) {
            this.listener.failed(ex);
            throw ex;
        }
        if (listener != null) {
            listener.success(object);
        }
    }

    public void failed(Exception e) {
        this.listener.failed(e);
    }

    public void cancelled() {
        this.listener.cancelled();
    }

    public interface IResponseListener {
        Object failed(Exception e);
        Object success(Object object);
        Object cancelled();
    }

}