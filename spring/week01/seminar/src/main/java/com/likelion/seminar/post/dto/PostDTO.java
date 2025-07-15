package com.likelion.seminar.post.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PostDTO {

    private String title;
    private String content;
    private String writer;
}
