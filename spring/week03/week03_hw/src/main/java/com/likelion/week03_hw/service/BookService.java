package com.likelion.week03_hw.service;

import com.likelion.week03_hw.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    // 책 추가함
    public void addBook(Book book) {
        books.add(book);
    }

    // 책 조회함
    public List<Book> getBooks() {
        return books;
    }
}

