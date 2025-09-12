package com.likelion.week07_hw.repository;

import com.likelion.week07_hw.entity.CommentEntity;
import com.likelion.week07_hw.entity.PostEntity;
import com.likelion.week07_hw.entity.WriterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WriterRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test

    void WriterTest(){
        WriterEntity writer = new WriterEntity();
        writer.setName("작성자");
        writerRepository.save(writer);

        PostEntity post = new PostEntity();
        post.setTitle("테스트 글");
        post.setContent("내용");
        post.setWriter(writer);
        writer.addPost(post);
        postRepository.save(post);

        CommentEntity comment = new CommentEntity();
        comment.setComment("댓글");
        comment.setPost(post);
        comment.setWriter(writer);
        writer.addComment(comment);
        commentRepository.save(comment);


        WriterEntity saved = writerRepository.findById(writer.getId()).orElseThrow();

        System.out.println("작성자 이름: " + saved.getName());
        System.out.println("작성자가 쓴 글 개수: " + saved.getPosts().size());
        System.out.println("작성자가 쓴 댓글 개수: " + saved.getComments().size());

        saved.getPosts().forEach(p -> System.out.println("  글 제목: " + p.getTitle()));
        saved.getComments().forEach(c -> System.out.println("  댓글 내용: " + c.getComment()));

    }

}