package com.hzau.dp.service;

import com.hzau.dp.entity.Comment;
import com.hzau.dp.entity.CommentPlus;

import java.util.List;

public interface CommentService {
    int addComment(Comment comment);
    int deleteComment(Integer commentId);
    List<CommentPlus> listComment(Integer storeId);
    void calScore(Integer storeId);
    Comment queryById(Integer commentId);
}
