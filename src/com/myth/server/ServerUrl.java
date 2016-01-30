package com.myth.server;

import com.myth.config.ServerConfig;

/**
 * Created by mitesh on 26/01/16.
 */
public class ServerUrl {
    public static final String BASE_URL = ServerConfig.host+(ServerConfig.port>0?(":"+ServerConfig.port):"");

    public static final String CHANNEL = BASE_URL+"/channel";
    public static final String CHANNEL_DETAIL = BASE_URL+"/channeldetail";
    public static final String CHANNEL_PROPERTY = BASE_URL+"/channelproperty";
    public static final String CHANNEL_SHARED_OBJECT = BASE_URL+"/channelsharedobject";
    public static final String OBJECT_COMMENT = BASE_URL+"/objectcomment";
    public static final String OBJECT_LIKE = BASE_URL+"/objectlike";
    public static final String OBJECT_DETAIL = BASE_URL+"/objectdetail";
    public static final String USER = BASE_URL+"/user";
}
