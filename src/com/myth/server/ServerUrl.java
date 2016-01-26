package com.myth.server;

import com.myth.config.ServerConfig;

/**
 * Created by mitesh on 26/01/16.
 */
public class ServerUrl {
    public static final String BASE_URL = ServerConfig.host+(ServerConfig.port>0?(":"+ServerConfig.port):"");

    public static final String CREATE_CHANNEL = BASE_URL+"/channel/create";
}
