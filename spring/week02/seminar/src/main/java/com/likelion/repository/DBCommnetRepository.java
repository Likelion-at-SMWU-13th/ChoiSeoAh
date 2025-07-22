package com.likelion.repository;

import com.likelion.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommnetRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());

    }
}
