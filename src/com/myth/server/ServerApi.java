package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.Channel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mitesh on 26/01/16.
 */
public class ServerApi {

    public static void createChannel(Channel channel, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", JsonParser.getInstance().toJson(channel));
        HttpManager.getInstance().post(ServerUrl.CREATE_CHANNEL, params,
                new ResponseCallbackHandler(listener, new TypeToken<Channel>(){}.getType()), true);
    }
}
