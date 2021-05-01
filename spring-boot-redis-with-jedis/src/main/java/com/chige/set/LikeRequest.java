package com.chige.set;

import com.chige.redistemplate.model.User;
import lombok.Data;

@Data
public class LikeRequest extends User {

    /**
     *  点赞类型 1点赞 0取消点赞
     */
    private Integer likeType;
    /**
     *  笔记id-被点赞对象id
     */
    private Integer noteId;

}
