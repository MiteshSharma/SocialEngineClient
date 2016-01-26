package com.myth.social;

/**
 * Created by mitesh on 26/01/16.
 */
public interface IEventListener {
    public void onEvent(EventType e, EventResult r,  Object dataObject);
}
