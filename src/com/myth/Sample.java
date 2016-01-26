package com.myth;

import com.myth.pojo.Channel;
import com.myth.social.ChannelHandler;
import com.myth.social.EventResult;
import com.myth.social.EventType;
import com.myth.social.IEventListener;

/**
 * Created by mitesh on 25/01/16.
 */
public class Sample {

    public static void main(String[] args) {
        ChannelHandler channelHandler = new ChannelHandler(new IEventListener() {
            @Override
            public void onEvent(EventType e, EventResult r, Object dataObject) {

            }
        });
        Channel channel = new Channel();
        channel.name = "MyChannel";
        channel.description = "Desc";
        channel.ownerId = 1;
        channel.userCount = 1;
        channelHandler.createChannel(channel);
    }

}
