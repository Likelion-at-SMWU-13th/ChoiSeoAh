package com.likelion.week07_hw.repository;

import com.likelion.week07_hw.entity.CommentEntity;
import com.likelion.week07_hw.entity.PostEntity;
import com.likelion.week07_hw.entity.WriterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    void CommentTest(){
        WriterEntity writer = new WriterEntity();
        writer.setName("아기사자");
        writerRepository.save(writer);

        PostEntity post = new PostEntity();
        post.setTitle(" 테스트 글");
        post.setContent("내용");
        post.setWriter(writer);
        postRepository.save(post);

        CommentEntity comment = new CommentEntity();
        comment.setComment("첫 댓글");
        comment.setPost(post);
        comment.setWriter(writer);
        commentRepository.save(comment);

        CommentEntity saved = commentRepository.findById(comment.getId()).orElseThrow();

        System.out.println("댓글 내용: " + saved.getComment());
        System.out.println("댓글 작성자: " + saved.getWriter().getName());
        System.out.println("댓글이 달린 글 제목: " + saved.getPost().getTitle());

    }


}