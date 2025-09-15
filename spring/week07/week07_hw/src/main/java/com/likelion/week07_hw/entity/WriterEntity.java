package com.likelion.week07_hw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="writer")
@Getter
@Setter
@NoArgsConstructor

public class WriterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String  name;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<PostEntity> posts =  new ArrayList<>();

    @OneToMany(mappedBy = "writer", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<CommentEntity> comments = new ArrayList<>();

    public void addPost(PostEntity post) {
        posts.add(post);
        post.setWriter(this);
    }

    public void addComment(CommentEntity comment) {
        comments.add(comment);
        comment.setWriter(this);
    }






}
