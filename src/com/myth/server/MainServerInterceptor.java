package com.myth.server;

import com.myth.coreserver.RequestDetail;
import com.myth.coreserver.RequestInterceptor;

/**
 * Created by mitesh on 29/01/16.
 */
public class MainServerInterceptor implements RequestInterceptor {
    @Override
    public RequestDetail intercept() {
        RequestDetail requestDetail = new RequestDetail();
        requestDetail.addParam("email", "user@gmail.com");
        return requestDetail;
    }
}
