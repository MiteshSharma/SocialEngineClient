package com.myth.social;

import com.myth.coreserver.ResponseCallbackListener;

/**
 * Created by mitesh on 26/01/16.
 */
public class BaseHandler implements ResponseCallbackListener {
    EventType eventType;
    IEventListener listener;

    public BaseHandler(IEventListener listener){
        this.listener = listener;
    }

    public void startEvent(EventType type){
        this.eventType = type;
        if (this.listener != null) {
            this.listener.onEvent(this.eventType, EventResult.START, null);
        }
    }

    @Override
    public void success(Object object) {
        if (this.listener != null) {
            this.listener.onEvent(this.eventType, EventResult.SUCCESS, object);
            this.listener.onEvent(this.eventType, EventResult.COMPLETE, null);
        }
    }

    @Override
    public void failure(Exception ex) {
        if (this.listener != null) {
            this.listener.onEvent(this.eventType, EventResult.ERROR, ex);
            this.listener.onEvent(this.eventType, EventResult.COMPLETE, null);
        }
    }

    @Override
    public void cancelled() {
        if (this.listener != null) {
            this.listener.onEvent(this.eventType, EventResult.CANCEL, null);
            this.listener.onEvent(this.eventType, EventResult.COMPLETE, null);
        }
    }

    public void dispose() {
        this.listener = null;
    }
}
