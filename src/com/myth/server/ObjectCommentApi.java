package com.myth.server;

import com.google.gson.reflect.TypeToken;
import com.myth.coreserver.HttpManager;
import com.myth.coreserver.ResponseCallbackHandler;
import com.myth.coreserver.ResponseCallbackListener;
import com.myth.pojo.ObjectComment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mitesh on 30/01/16.
 */
public class ObjectCommentApi {

    HttpManager httpManager;
    public ObjectCommentApi(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void create(int objectId, String objectType, String comment, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        params.put("comment", comment);
        this.httpManager.post(ServerUrl.OBJECT_COMMENT, params,
                new ResponseCallbackHandler(listener, new TypeToken<ObjectComment>() {
                }.getType()), true);
    }

    public void update(int objectCommentId, String comment, ResponseCallbackListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("object_comment_id", objectCommentId);
        params.put("comment", comment);
        this.httpManager.put(ServerUrl.OBJECT_COMMENT, params,
                new ResponseCallbackHandler(listener, new TypeToken<ObjectComment>() {
                }.getType()), true);
    }

    /**
     * request type can be id where object is deleted based on object comment id or can be object where comments can be deleted
     * for all objects based on its object id and object type
     * responseType: id, object
     */
    public void delete(int objectId, String objectType, int objectCommentId, String requestType, ResponseCallbackListener listener) {
        if (!(requestType.equals("id") || requestType.equals("object"))) {
            throw new IllegalArgumentException("Incorrect request type.");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        params.put("response_type", requestType);
        params.put("object_comment_id", objectCommentId);
        this.httpManager.delete(ServerUrl.OBJECT_COMMENT, params,
                new ResponseCallbackHandler(listener, new TypeToken<ObjectComment>() {
                }.getType()), true);
    }

    /**
     * request type can be id where object is read based on object comment id or can be object where comments can be read
     * for all objects based on its object id and object type or can be user where comments get based on user.
     * responseType: id, object, user
     */
    public void read(int objectId, String objectType, int objectCommentId, String requestType, ResponseCallbackListener listener) {
        if (!(requestType.equals("id") || requestType.equals("object") || requestType.equals("user"))) {
            throw new IllegalArgumentException("Incorrect request type.");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("object_id", objectId);
        params.put("object_type", objectType);
        params.put("response_type", requestType);
        params.put("object_comment_id", objectCommentId);
        this.httpManager.get(ServerUrl.OBJECT_LIKE, params,
                new ResponseCallbackHandler(listener, new TypeToken<List<ObjectComment>>() {
                }.getType()), true);
    }
}
