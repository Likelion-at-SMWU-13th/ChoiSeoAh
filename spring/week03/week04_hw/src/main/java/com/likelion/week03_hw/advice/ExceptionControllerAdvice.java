package com.likelion.week03_hw.advice;

import com.likelion.week03_hw.dto.ErrorDetails;
import com.likelion.week03_hw.exceptions.BookNotFoundException;
import com.likelion.week03_hw.exceptions.DuplicateBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails>  BookNotFoundHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("No books found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);

    }

    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity<ErrorDetails>  DuplicateBookHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("The book already exists");

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

}
