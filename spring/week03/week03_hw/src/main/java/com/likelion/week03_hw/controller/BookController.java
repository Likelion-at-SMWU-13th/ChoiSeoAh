package com.likelion.week03_hw.controller;

import com.likelion.week03_hw.model.Book;
import com.likelion.week03_hw.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String viewBooks(Model model) {
        var books = bookService.getBooks();
        model.addAttribute("books",books);
        return "books.html";

    }

    @PostMapping("/books")
    public String addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int price,
            Model model
    ){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        bookService.addBook(book);

        var books = bookService.getBooks();
        model.addAttribute("books",books);

        return "books.html";
    }
}
