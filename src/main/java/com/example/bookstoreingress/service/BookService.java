package com.example.bookstoreingress.service;

import com.example.bookstoreingress.dao.BookRepository;
import com.example.bookstoreingress.dto.BookDTO;
import com.example.bookstoreingress.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getReadingList(Integer studentId) {
        List<BookDTO> books = bookRepository.findBooksForStudent(studentId);
        return books;
    }
}
