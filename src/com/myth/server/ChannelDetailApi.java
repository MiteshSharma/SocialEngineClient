package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.Channel;
import com.myth.pojo.ChannelDetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mitesh on 30/01/16.
 */
public class ChannelDetailApi {

    HttpManager httpManager;
    public ChannelDetailApi(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void create(Channel channel, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        this.httpManager.post(ServerUrl.CHANNEL_DETAIL, params,
                new ResponseCallbackHandler(listener, new TypeToken<ChannelDetail>() {
                }.getType()), true);
    }

    /**
     * Request type can be id where we get all channels based on user id or channel where channel from channel id.
     * Request type : id, channel
     */
    public void read(int channelId, String requestType, ResponseCallbackListener listener) {
        if (!(requestType.equals("id") || requestType.equals("channel"))) {
            throw new IllegalArgumentException("Incorrect request type.");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("channel_id", channelId);
        params.put("request_type", requestType);
        this.httpManager.get(ServerUrl.CHANNEL_DETAIL, params,
                new ResponseCallbackHandler(listener, new TypeToken<List<ChannelDetail>>() {
                }.getType()), true);
    }

    public void delete(Channel channel, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        this.httpManager.delete(ServerUrl.CHANNEL_DETAIL, params,
                new ResponseCallbackHandler(listener, new TypeToken<Channel>() {
                }.getType()), true);
    }

    public void update(Channel channel, ResponseCallbackListener listener) {
        throw new UnsupportedOperationException("This call is not supported.");
    }
}
