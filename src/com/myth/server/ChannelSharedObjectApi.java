package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.Channel;
import com.myth.pojo.ChannelShareObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mitesh on 30/01/16.
 */
public class ChannelSharedObjectApi {

    HttpManager httpManager;
    public ChannelSharedObjectApi(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void create(Channel channel, int objectId, String objectType, String message, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        params.put("message", message);
        this.httpManager.post(ServerUrl.CHANNEL_SHARED_OBJECT, params,
                new ResponseCallbackHandler(listener, new TypeToken<ChannelShareObject>() {
                }.getType()), true);
    }

    public void delete(int channelShareObjectId, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel_share_object_id", channelShareObjectId);
        this.httpManager.delete(ServerUrl.CHANNEL_SHARED_OBJECT, params,
                new ResponseCallbackHandler(listener, new TypeToken<ChannelShareObject>() {
                }.getType()), true);
    }

    /**
     * Request type can be id where we get all channel objects based on userid and channelId
     * or channel where channel objects from channel id.
     * Request type : id, channel
     */
    public void read(Channel channel, String requestType, ResponseCallbackListener listener) {
        if (!(requestType.equals("id") || requestType.equals("channel"))) {
            throw new IllegalArgumentException("Incorrect request type.");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        params.put("request_type", requestType);
        this.httpManager.get(ServerUrl.CHANNEL_SHARED_OBJECT, params,
                new ResponseCallbackHandler(listener, new TypeToken<List<ChannelShareObject>>() {
                }.getType()), true);
    }

    public void update(Channel channel, ResponseCallbackListener listener) {
        throw new UnsupportedOperationException("This call is not supported.");
    }
}
