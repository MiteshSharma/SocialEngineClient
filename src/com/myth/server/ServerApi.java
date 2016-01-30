package com.myth.server;

import com.myth.coreserver.HttpManager;

/**
 * Created by mitesh on 26/01/16.
 */
public class ServerApi {

    private static ServerApi mInstance;
    private HttpManager httpManager;
    private ChannelApi channelApi;
    private ChannelDetailApi channelDetailApi;
    private ChannelPropertyApi channelPropertyApi;
    private ChannelSharedObjectApi channelSharedObjectApi;
    private ObjectLikeApi objectLikeApi;
    private ObjectCommentApi objectCommentApi;
    private ObjectDetailApi objectDetailApi;
    private UserApi userApi;

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

    public ChannelApi getChannelApi() {
        if (channelApi == null) {
            channelApi = new ChannelApi(httpManager);
        }
        return channelApi;
    }

    public ChannelDetailApi getChannelDetailApi() {
        if (channelDetailApi == null) {
            channelDetailApi = new ChannelDetailApi(httpManager);
        }
        return channelDetailApi;
    }

    public ChannelPropertyApi getChannelPropertyApi() {
        if (channelPropertyApi == null) {
            channelPropertyApi = new ChannelPropertyApi(httpManager);
        }
        return channelPropertyApi;
    }

    public ChannelSharedObjectApi getChannelSharedObjectApi() {
        if (channelSharedObjectApi == null) {
            channelSharedObjectApi = new ChannelSharedObjectApi(httpManager);
        }
        return channelSharedObjectApi;
    }

    public ObjectLikeApi getObjectLikeApi() {
        if(objectLikeApi == null) {
            objectLikeApi = new ObjectLikeApi(httpManager);
        }
        return objectLikeApi;
    }

    public ObjectCommentApi getObjectCommentApi() {
        if(objectCommentApi == null) {
            objectCommentApi = new ObjectCommentApi(httpManager);
        }
        return objectCommentApi;
    }

    public ObjectDetailApi getObjectDetailApi() {
        if(objectDetailApi == null) {
            objectDetailApi = new ObjectDetailApi(httpManager);
        }
        return objectDetailApi;
    }

    public UserApi getUserApi() {
        if(userApi == null) {
            userApi = new UserApi(httpManager);
        }
        return userApi;
    }

    public static void dispose() {
        mInstance = null;
    }
}