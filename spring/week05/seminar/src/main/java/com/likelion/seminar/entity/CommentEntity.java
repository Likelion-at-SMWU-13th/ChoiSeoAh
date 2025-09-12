package com.likelion.seminar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="comment")
@Getter
@Setter
@NoArgsConstructor

public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @ToString.Exclude
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    @ToString.Exclude
    private WriterEntity writer;



}
