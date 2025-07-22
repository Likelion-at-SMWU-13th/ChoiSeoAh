package com.likelion;

import com.likelion.bean.Lion;
import com.likelion.bean.Person;
import com.likelion.config.ProjectConfig;
import com.likelion.model.Comment;
import com.likelion.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //Lion lion = context.getBean(Lion.class);

        Comment comment = new Comment();
        comment.setAuther("babylion");
        comment.setText("I like lion");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }

}