package com.likelion.week07_hw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="post")
@Getter
@Setter
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String  title;
    private String  content;


    @ManyToOne
    @JoinColumn(name = "writer_id")
    private WriterEntity writer;



}
