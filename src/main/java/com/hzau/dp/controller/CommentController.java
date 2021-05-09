package com.hzau.dp.controller;

import com.hzau.dp.entity.Comment;
import com.hzau.dp.entity.CommentPlus;
import com.hzau.dp.entity.Store;
import com.hzau.dp.service.CommentService;
import com.hzau.dp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    StoreService storeService;

    @RequestMapping(value = "list/commentlist")
    public Map<String,Object> list(@RequestBody Map<String,Integer> data){
        List<CommentPlus> list1 = commentService.listComment(data.get("storeid"));
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("commentInfo",list1);
        return modelMap;
    }

    @RequestMapping(value = "list/sendcomment")
    public Map<String,Object> add(@RequestBody Map<String,Object> data){
        Map<String,Object> model1 = new HashMap<>();
        Comment controller = new Comment();
        controller.setUserName((Integer) data.get("username"));
        controller.setStoreId((Integer) data.get("storeid"));
        controller.setCommentScore((Double) data.get("commentscore"));
        controller.setCommentText((String) data.get("commenttext"));
        int a1 = commentService.addComment(controller);
        if (a1 == 1) {
            model1.put("msg","评论成功！");
            commentService.calScore((Integer) data.get("storeid"));
            List<CommentPlus> list2 = commentService.listComment((Integer) data.get("storeid"));
            Store list3 = storeService.queryStoreById((Integer) data.get("storeid"));
            model1.put("commentInfo",list2);
            model1.put("storeInfo",list3);
        }else{
            model1.put("msg","评论失败");
        }
        return model1;
    }

    @RequestMapping(value = "/list/deletecomment")
    public Map<String,Object> delete(@RequestBody Map<String,Integer> data){
        Map<String,Object> model2 = new HashMap<>();
        Comment controller = new Comment();
        controller = commentService.queryById(data.get("commentid"));
        int a2 = commentService.deleteComment(data.get("commentid"));
        if(a2==1){
            model2.put("msg","删除评论成功！");
            commentService.calScore(controller.getStoreId());
            List<CommentPlus> list3 = commentService.listComment(controller.getStoreId());
            Store list4 = storeService.queryStoreById(controller.getStoreId());
            model2.put("commentInfo",list3);
            model2.put("storeInfo",list4);
        }else{
            model2.put("msg","删除评论失败！");
        }
        return model2;

    }

}
