package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.Channel;
import com.myth.pojo.ChannelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mitesh on 30/01/16.
 */
public class ChannelPropertyApi {

    HttpManager httpManager;
    public ChannelPropertyApi(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void create(Channel channel, String name, String value, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        params.put("name", name);
        params.put("value", value);
        this.httpManager.post(ServerUrl.CHANNEL_PROPERTY, params,
                new ResponseCallbackHandler(listener, new TypeToken<ChannelProperty>() {
                }.getType()), true);
    }

    public void update(Channel channel, String name, String value, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        params.put("name", name);
        params.put("value", value);
        this.httpManager.put(ServerUrl.CHANNEL_PROPERTY, params,
                new ResponseCallbackHandler(listener, new TypeToken<ChannelProperty>() {
                }.getType()), true);
    }

    public void read(Channel channel, String name, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        params.put("name", name);
        this.httpManager.get(ServerUrl.CHANNEL_PROPERTY, params,
                new ResponseCallbackHandler(listener, new TypeToken<ChannelProperty>() {
                }.getType()), true);
    }

    public void delete(Channel channel, ResponseCallbackListener listener) {
        throw new UnsupportedOperationException("This call is not supported.");
    }
}
