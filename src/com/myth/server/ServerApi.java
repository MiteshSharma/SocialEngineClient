package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.Channel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mitesh on 26/01/16.
 */
public class ServerApi {

    private static ServerApi mInstance;
    HttpManager httpManager;

    public static ServerApi getInstance() {
        if (mInstance == null) {
            mInstance = new ServerApi();
        }
        return mInstance;
    }

    public ServerApi() {
        this.httpManager = new HttpManager();
        this.httpManager.setRequestInterceptor(new MainServerInterceptor());
    }

    public void createChannel(Channel channel, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        this.httpManager.post(ServerUrl.CREATE_CHANNEL, params,
                new ResponseCallbackHandler(listener, new TypeToken<Channel>() {
                }.getType()), true);
    }

    public static void dispose() {
        mInstance = null;
    }
}