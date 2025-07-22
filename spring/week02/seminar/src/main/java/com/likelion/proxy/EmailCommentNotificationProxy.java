package com.likelion.proxy;

import com.likelion.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("sending notification via email:" + comment.getText());
    }
}
