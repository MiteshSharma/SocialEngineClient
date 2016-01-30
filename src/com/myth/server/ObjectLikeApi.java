package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.ObjectLike;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mitesh on 30/01/16.
 */
public class ObjectLikeApi {

    HttpManager httpManager;
    public ObjectLikeApi(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void create(int objectId, String objectType, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        this.httpManager.post(ServerUrl.OBJECT_LIKE, params,
                new ResponseCallbackHandler(listener, new TypeToken<ObjectLike>() {
                }.getType()), true);
    }

    /**
     * request type can be id where object is deleted based on object like id or can be object where likes can be deleted
     * for all objects based on its object id and object type
     * responseType: id, object
     */
    public void delete(int objectId, String objectType, int objectLikeId, String requestType, ResponseCallbackListener listener) {
        if (!(requestType.equals("id") || requestType.equals("object"))) {
            throw new IllegalArgumentException("Incorrect request type.");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        params.put("response_type", requestType);
        params.put("object_like_id", objectLikeId);
        this.httpManager.delete(ServerUrl.OBJECT_LIKE, params,
                new ResponseCallbackHandler(listener, new TypeToken<ObjectLike>() {
                }.getType()), true);
    }

    /**
     * request type can be id where object is read based on object like id or can be object where likes can be read
     * for all objects based on its object id and object type or can be user where likes get based on user.
     * responseType: id, object, user
     */
    public void read(int objectId, String objectType, int objectLikeId, String requestType, ResponseCallbackListener listener) {
        if (!(requestType.equals("id") || requestType.equals("object") || requestType.equals("user"))) {
            throw new IllegalArgumentException("Incorrect request type.");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        params.put("response_type", requestType);
        params.put("object_like_id", objectLikeId);
        this.httpManager.get(ServerUrl.OBJECT_LIKE, params,
                new ResponseCallbackHandler(listener, new TypeToken<List<ObjectLike>>() {
                }.getType()), true);
    }

    public void update(int objectId, String objectType, ResponseCallbackListener listener) {
        throw new UnsupportedOperationException("This call is not supported.");
    }
}
