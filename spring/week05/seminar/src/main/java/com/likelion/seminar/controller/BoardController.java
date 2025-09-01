package com.likelion.seminar.controller;

import com.likelion.seminar.dto.BoardDto;
import com.likelion.seminar.dto.PostDto;
import com.likelion.seminar.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    public BoardController(@Autowired BoardService boardService) { this.boardService = boardService = boardService; }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody BoardDto boardDto) { this.boardService.createBoard(boardDto); }

    @GetMapping("{id}")
    public BoardDto readBoard(@PathVariable("id") int id) { return this.boardService.readBoard(id);}

    @GetMapping("")
    public List<BoardDto> readAllBoards() { return this.boardService.readAllBoards();}

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(@PathVariable("id") int id, @RequestBody BoardDto boardDto) {
        this.boardService.updateBoard(id, boardDto);}

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBoard(@PathVariable("id") int id) { this.boardService.deleteBoard(id);}
}
