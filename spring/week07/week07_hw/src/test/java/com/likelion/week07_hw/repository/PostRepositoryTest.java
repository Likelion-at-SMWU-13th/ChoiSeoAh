package com.likelion.week07_hw.repository;


import com.likelion.week07_hw.entity.PostEntity;
import com.likelion.week07_hw.entity.WriterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private WriterRepository writerRepository;


    @Test
    void crestePostTest(){
        WriterEntity writer = new WriterEntity();
        writer.setName("아기사자");
        writerRepository.save(writer);

        PostEntity post = new PostEntity();
        post.setWriter(writer);
        post.setTitle("첫 글");
        post.setContent("첫 글 내용");
        postRepository.save(post);

        PostEntity saved = postRepository.findById(post.getId()).orElseThrow();


        System.out.println("제목: " + saved.getTitle());
        System.out.println("내용: " + saved.getContent());
        System.out.println("작성자: " + saved.getWriter().getName());

    }

}