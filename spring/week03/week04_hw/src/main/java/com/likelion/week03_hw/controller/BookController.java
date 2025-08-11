package com.likelion.week03_hw.controller;
import com.likelion.week03_hw.dto.BookDTO;
import com.likelion.week03_hw.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name = "Book 컨트롤러", description = "책을 추가하고 조회함")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @Operation(summary = "Book list api", description = "추가한 책 전체 리스츠 보기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "책이 없음")
    })
    public ResponseEntity<List<BookDTO>> viewBooks() {
        List<BookDTO> books = this.bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/books")
    @Operation(summary = "Add book api", description = "책 추가하기")
    @Parameters({
            @Parameter(name = "title", description = "책 제목", example = "소년이 온다"),
            @Parameter(name = "author", description = "저자", example = "한강"),
            @Parameter(name = "price", description = "가격", example = "15000")
    })
    public ResponseEntity<BookDTO> addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int price
    ) {
        BookDTO book = new BookDTO();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);

        bookService.addBook(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("X-Message", "Book created")
                .body(book);
    }

}
