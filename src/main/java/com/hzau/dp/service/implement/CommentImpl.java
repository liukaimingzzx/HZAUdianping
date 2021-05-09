package com.hzau.dp.service.implement;

import com.hzau.dp.dao.CommentDao;
import com.hzau.dp.entity.Comment;
import com.hzau.dp.entity.CommentPlus;
import com.hzau.dp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Override
    public int addComment(Comment comment) {
        int flag = commentDao.addComment(comment);
        if(flag>0){
            return 1;
        }else{
            throw new RuntimeException("评论失败！");
        }
    }

    @Override
    public int deleteComment(Integer commentId) {
        int flag = commentDao.deleteComment(commentId);
        if(flag>0){
            return 1;
        }else{
            throw new RuntimeException("删除评论失败！");
        }
    }

    @Override
    public List<CommentPlus> listComment(Integer storeId) {
        return commentDao.listComment(storeId);
    }

    @Override
    public void calScore(Integer storeId) {
        commentDao.calScore(storeId);
    }

    @Override
    public Comment queryById(Integer commentId) {
        return commentDao.queryById(commentId);
    }
}
