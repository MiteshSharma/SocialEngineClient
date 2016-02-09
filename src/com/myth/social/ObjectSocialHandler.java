package com.myth.social;

import com.myth.server.ServerApi;
import com.sun.corba.se.spi.activation.Server;

/**
 * Created by mitesh on 26/01/16.
 */
public class ObjectSocialHandler extends BaseHandler {
    public ObjectSocialHandler(IEventListener listener) {
        super(listener);
    }

    public void likeObject(int objectId, String objectType) {
        this.startEvent(EventType.LIKE_OBJECT);
        ServerApi.getInstance().getObjectLikeApi().create(objectId, objectType, this);
    }

    public void unlikeObject(int objectLikeId) {
        this.startEvent(EventType.UNLIKE_OBJECT);
        ServerApi.getInstance().getObjectLikeApi().delete(-1, "", objectLikeId, "id", this);
    }

    public void getObjectLikes(int objectId, String objectType) {
        this.startEvent(EventType.GET_LIKES);
        ServerApi.getInstance().getObjectLikeApi().read(objectId, objectType, -1, "object", this);
    }

    public void addComment(int objectId, String objectType, String comment) {
        this.startEvent(EventType.ADD_COMMENT);
        ServerApi.getInstance().getObjectCommentApi().create(objectId, objectType, comment, this);
    }

    public void updateComment(int objectCommentId, String comment) {
        this.startEvent(EventType.UPDATE_COMMENT);
        ServerApi.getInstance().getObjectCommentApi().update(objectCommentId, comment, this);
    }

    public void deleteComment(int objectCommentId) {
        this.startEvent(EventType.DELETE_COMMENT);
        ServerApi.getInstance().getObjectCommentApi().delete(-1, "", objectCommentId, "id", this);
    }

    public void getComments(int objectId, String objectType) {
        this.startEvent(EventType.READ_COMMENTS);
        ServerApi.getInstance().getObjectCommentApi().read(objectId, objectType, -1, "object", this);
    }
}