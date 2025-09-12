package com.likelion.seminar.entity;

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
    private long   id;
    private String  writer;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<PostEntity> posts =  new ArrayList<>();

    @OneToMany(mappedBy = "comment", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<CommentEntity> comments = new ArrayList<>();



}
