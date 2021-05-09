package com.hzau.dp.dao;


import com.hzau.dp.entity.Comment;
import com.hzau.dp.entity.CommentPlus;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommentDao {
    int addComment(Comment comment);
    int deleteComment(Integer commentId);
    List<CommentPlus> listComment(Integer storeId);
    void calScore(Integer storeId);
    Comment queryById(Integer commentId);
}
