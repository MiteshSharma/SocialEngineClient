package com.myth.pojo;

import java.util.List;

/**
 * Created by mitesh on 26/01/16.
 */
public class ObjectDetail {
    public int objectId;
    public String objectType;
    public int likeCount;
    public int commentCount;
    public List<ObjectLike> objectLikes;
    public List<ObjectComment> objectComments;
}
