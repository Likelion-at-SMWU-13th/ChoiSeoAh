package com.likelion.week03_hw.service;

import com.likelion.week03_hw.dto.BookDTO;
import com.likelion.week03_hw.exceptions.BookNotFoundException;
import com.likelion.week03_hw.exceptions.DuplicateBookException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<BookDTO> books = new ArrayList<>();

    // 책 추가함
    public void addBook(BookDTO book) {
        // 중복 체크: 제목과 저자가 같은 책이 이미 있는지 확인
        boolean exists = books.stream()
                .anyMatch(b -> b.getTitle().equals(book.getTitle())
                        && b.getAuthor().equals(book.getAuthor()));

        if (exists) {
            throw new DuplicateBookException();
        }

        books.add(book);
    }


    // 책 조회함
    public List<BookDTO> getBooks() {
        if(books.isEmpty()) {
            throw new BookNotFoundException();
        }
        return books;
    }
}

