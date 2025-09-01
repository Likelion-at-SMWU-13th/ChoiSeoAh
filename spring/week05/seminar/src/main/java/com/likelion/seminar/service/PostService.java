package com.likelion.seminar.service;

import com.likelion.seminar.dto.PostDto;
import com.likelion.seminar.entity.BoardEntity;
import com.likelion.seminar.entity.PostEntity;
import com.likelion.seminar.repository.BoardRepository;
import com.likelion.seminar.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostService(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    // 게시글 생성
    public void createPost(PostDto postDto) {
        BoardEntity board = boardRepository.findById((long) postDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        postEntity.setWriter(postDto.getWriter());
        postEntity.setBoardEntity(board);

        postRepository.save(postEntity);

    }

    // 게시글 단건 조회
    public PostDto readPost(int id) {
        PostEntity postEntity = postRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        return new PostDto(
                (int)postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ? 0 : postEntity.getBoardEntity().getId().intValue()
        );
    }

    // 게시글 전체 조회
    public List<PostDto> readPostAll() {
        Iterable<PostEntity> iterable = postRepository.findAll();
        List<PostEntity> postEntities = new ArrayList<>();
        iterable.forEach(postEntities::add);

        List<PostDto> postDtoList = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            postDtoList.add(new PostDto(
                    (int)postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null ? 0 : postEntity.getBoardEntity().getId().intValue()
            ));
        }
        return postDtoList;
    }

    // 게시글 수정
    public void updatePost(int id, PostDto postDto) {
        PostEntity postEntity = postRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        postEntity.setWriter(postDto.getWriter());

        if (postDto.getBoardId() != 0) {
            BoardEntity board = boardRepository.findById((long) postDto.getBoardId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));
            postEntity.setBoardEntity(board);
        }

        postRepository.save(postEntity);

    }

    // 게시글 삭제
    public void deletePost(int id) {
        if (!postRepository.existsById((long) id)) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
        postRepository.deleteById((long) id);

    }
}
