package com.likelion.seminar.service;

import com.likelion.seminar.dto.BoardDto;
import com.likelion.seminar.dto.PostDto;
import com.likelion.seminar.entity.BoardEntity;
import com.likelion.seminar.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시판 생성
    public void createBoard(BoardDto boardDto) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(boardDto.getName());

        boardRepository.save(boardEntity);

    }

    // 특정 게시판 조회
    public BoardDto readBoard(int id) {
        BoardEntity boardEntity = boardRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));

        // 게시글 Entity → DTO 변환
        List<PostDto> postDtoList = new ArrayList<>();
        boardEntity.getPostEntityList().forEach(postEntity -> postDtoList.add(
                new PostDto(
                        (int)postEntity.getId(),
                        postEntity.getTitle(),
                        postEntity.getContent(),
                        postEntity.getWriter(),
                        boardEntity.getId().intValue()
                )
        ));

        return new BoardDto(
                boardEntity.getId().intValue(),
                boardEntity.getName(),
                postDtoList
        );
    }

    // 전체 게시판 조회
    public List<BoardDto> readAllBoards() {
        Iterable<BoardEntity> iterable = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        iterable.forEach(boardEntity -> {
            // 게시글 Entity → DTO 변환
            List<PostDto> postDtoList = new ArrayList<>();
            boardEntity.getPostEntityList().forEach(postEntity -> {
                postDtoList.add(new PostDto(
                        (int)postEntity.getId(),
                        postEntity.getTitle(),
                        postEntity.getContent(),
                        postEntity.getWriter(),
                        boardEntity.getId().intValue()
                ));
            });

            // BoardDto 생성 (게시판 + 게시글 리스트)
            boardDtoList.add(new BoardDto(
                    boardEntity.getId().intValue(),
                    boardEntity.getName(),
                    postDtoList
            ));
        });

        return boardDtoList;
    }


    // 게시판 수정
    public void updateBoard(int id, BoardDto boardDto) {
        BoardEntity boardEntity = boardRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));

        boardEntity.setName(boardDto.getName());

        boardRepository.save(boardEntity);}

    // 게시판 삭제
    public void deleteBoard(int id) {
        if (!boardRepository.existsById((long) id)) {
            throw new IllegalArgumentException("해당 게시판이 존재하지 않습니다.");
        }
        boardRepository.deleteById((long) id);
    }
}
