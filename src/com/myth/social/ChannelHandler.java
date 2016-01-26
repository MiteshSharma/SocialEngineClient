package com.myth.social;

import com.myth.pojo.Channel;
import com.myth.server.ServerApi;

/**
 * Created by mitesh on 26/01/16.
 */
public class ChannelHandler extends BaseHandler {

    public ChannelHandler(IEventListener listener) {
        super(listener);
    }

    public void createChannel(Channel channel) {
        this.startEvent(EventType.CREATE_CHANNEL);
        ServerApi.createChannel(channel, this);
    }
}
