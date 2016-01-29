package com.myth.coreserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mitesh on 29/01/16.
 */
public class RequestDetail {
    Map<String, String> headerMap;
    Map<String, String> paramMap;

    public void addHeader(String name, String value) {
        if (headerMap == null) {
            headerMap = new HashMap<>();
        }
        headerMap.put(name, value);
    }

    public void addParam(String name, String value) {
        if (paramMap == null) {
            paramMap = new HashMap<>();
        }
        paramMap.put(name, value);
    }

    public Map<String, String> getHeaderMap() {
        if (headerMap == null) {
            headerMap = new HashMap<>();
        }
        return headerMap;
    }

    public Map<String, String> getParamMap() {
        if (paramMap == null) {
            paramMap = new HashMap<>();
        }
        return paramMap;
    }
}
