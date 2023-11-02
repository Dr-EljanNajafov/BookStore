package com.example.bookstoreingress.controller;

import com.example.bookstoreingress.dto.BookDTO;
import com.example.bookstoreingress.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRESTController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{studentId}/books")
    public ResponseEntity<List<BookDTO>> getReadingList(@PathVariable Integer studentId) {
        List<BookDTO> books = bookService.getReadingList(studentId);
        return ResponseEntity.ok(books);
    }
}

