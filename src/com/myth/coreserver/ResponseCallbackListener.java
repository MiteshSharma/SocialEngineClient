package com.myth.coreserver;

/**
 * Created by mitesh on 26/01/16.
 */
public interface ResponseCallbackListener {
    public void success(Object object);

    public void failure(Exception ex);

    public void cancelled();
}
