package com.myth.social;

import com.myth.pojo.Channel;
import com.myth.server.ServerApi;
import com.sun.corba.se.spi.activation.Server;

/**
 * Created by mitesh on 26/01/16.
 */
public class ChannelHandler extends BaseHandler {

    public ChannelHandler(IEventListener listener) {
        super(listener);
    }

    public void createChannel(Channel channel) {
        this.startEvent(EventType.CREATE_CHANNEL);
        ServerApi.getInstance().getChannelApi().create(channel, this);
    }

    public void readChannelsByOwner() {
        this.startEvent(EventType.READ_CHANNELS);
        ServerApi.getInstance().getChannelApi().read(-1, "owner", this);
    }

    public void readChannel(int channelId) {
        this.startEvent(EventType.READ_CHANNELS);
        ServerApi.getInstance().getChannelApi().read(channelId, "id", this);
    }

    public void deleteChannel(Channel channel) {
        this.startEvent(EventType.DELETE_CHANNEL);
        ServerApi.getInstance().getChannelApi().delete(channel, this);
    }

    public void subscribeChannel(Channel channel) {
        this.startEvent(EventType.SUBSCRIBE_CHANNEL);
        ServerApi.getInstance().getChannelDetailApi().create(channel, this);
    }

    public void unsubscribeChannel(Channel channel) {
        this.startEvent(EventType.UNSUBSCRIBE_CHANNEL);
        ServerApi.getInstance().getChannelDetailApi().delete(channel, this);
    }

    public void readChannelDetail(Channel channel) {
        this.startEvent(EventType.READ_CHANNEL_DETAIL);
        ServerApi.getInstance().getChannelDetailApi().read(channel.id, "channel", this);
    }

    public void readChannelForUser() {
        this.startEvent(EventType.READ_CHANNEL_DETAIL);
        ServerApi.getInstance().getChannelDetailApi().read(-1, "id", this);
    }

    public void addUpdateChannelProperty(Channel channel, String name, String value) {
        this.startEvent(EventType.ADD_CHANNEL_PROPERTY);
        ServerApi.getInstance().getChannelPropertyApi().create(channel, name, value, this);
    }

    public void getChannelProperty(Channel channel, String name) {
        this.startEvent(EventType.READ_CHANNEL_PROPERTY);
        ServerApi.getInstance().getChannelPropertyApi().read(channel, name, "id", this);
    }

    public void getAllChannelProperties(Channel channel, String name) {
        this.startEvent(EventType.READ_CHANNEL_PROPERTY);
        ServerApi.getInstance().getChannelPropertyApi().read(channel, name, "channel", this);
    }

    public void shareObjectWithChannel(Channel channel, int objectId, String objectType, String message) {
        this.startEvent(EventType.SHARE_OBJECT_CHANNEL);
        ServerApi.getInstance().getChannelSharedObjectApi().create(channel, objectId, objectType, message, this);
    }

    public void getAllSharedObjectsWithChannel(Channel channel)  {
        this.startEvent(EventType.READ_SHARED_OBJECTS_CHANNEL);
        ServerApi.getInstance().getChannelSharedObjectApi().read(channel, "channel", this);
    }

    public void deleteSharedObjectWithChannel(int sharedChannelObjectId) {
        this.startEvent(EventType.DELETE_SHARED_OBJECT_CHANNEL);
        ServerApi.getInstance().getChannelSharedObjectApi().delete(sharedChannelObjectId, this);
    }
}