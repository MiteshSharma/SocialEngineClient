package com.myth.coreserver;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by mitesh on 26/01/16.
 */
class HttpHelper {
    public static final String STRING="STRING";
    public static final String FILE="FILE";
    public static final String BYTES="BYTE";
    public static final String INPUTSTREAM="INPUTSTREAM";
    private static final List<String> ALL_ENTITY = Arrays.asList(STRING, BYTES, FILE, INPUTSTREAM);

    public static HttpEntity getHttpEntity(Map<String, Object> map, String encoding) throws UnsupportedEncodingException {
        HttpEntity entity = null;
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        if(map!=null && map.size()>0){
            boolean isAmoungEntity = false;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if(ALL_ENTITY.contains(entry.getKey())){
                    isAmoungEntity = true;
                    if(STRING.equals(entry.getKey())){
                        entity = new StringEntity(String.valueOf(entry.getValue()), encoding);
                        break;
                    } else if(BYTES.equals(entry.getKey())){
                        entity = new ByteArrayEntity((byte[])entry.getValue());
                        break;
                    } else if(FILE.equals(entry.getKey())){
                        entity = new FileEntity((File)entry.getValue());
                        break;
                    } else if(INPUTSTREAM.equals(entry.getKey())){
						entity = new InputStreamEntity((InputStream)entry.getValue());
                        break;
                    } else {
                        nameValuePairList.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
                    }
                } else{
                    nameValuePairList.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
                }
            }

            if(!isAmoungEntity) {
                entity = new UrlEncodedFormEntity(nameValuePairList, encoding);
            }
        }
        return entity;
    }

}
