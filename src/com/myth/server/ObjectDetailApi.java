package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.ObjectDetail;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mitesh on 30/01/16.
 */
public class ObjectDetailApi {
    HttpManager httpManager;
    public ObjectDetailApi(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void read(int objectId, String objectType, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        this.httpManager.get(ServerUrl.OBJECT_DETAIL, params,
                new ResponseCallbackHandler(listener, new TypeToken<ObjectDetail>() {
                }.getType()), true);
    }

    public void create(int objectId, String objectType, ResponseCallbackListener listener) {
        throw new UnsupportedOperationException("This call is not supported.");
    }

    public void delete(int objectId, String objectType, ResponseCallbackListener listener) {
        throw new UnsupportedOperationException("This call is not supported.");
    }

    public void update(int objectId, String objectType, ResponseCallbackListener listener) {
        throw new UnsupportedOperationException("This call is not supported.");
    }
}
