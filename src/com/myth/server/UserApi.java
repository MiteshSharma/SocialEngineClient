package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mitesh on 30/01/16.
 */
public class UserApi {
    HttpManager httpManager;
    public UserApi(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void create(ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        this.httpManager.get(ServerUrl.USER, params,
                new ResponseCallbackHandler(listener, new TypeToken<User>() {
                }.getType()), true);
    }

    public void read() {
        throw new UnsupportedOperationException("This call is not supported.");
    }

    public void delete() {
        throw new UnsupportedOperationException("This call is not supported.");
    }

    public void update() {
        throw new UnsupportedOperationException("This call is not supported.");
    }
}
