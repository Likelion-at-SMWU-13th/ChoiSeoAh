package com.likelion.seminar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int id;      // 게시판 고유번호
    private String name; // 게시판 이름
    private List<PostDto> posts;

    @Override
    public String toString() {
        return "BoardDto{" + "name=" + name + '\'' + "}";
    }
}

