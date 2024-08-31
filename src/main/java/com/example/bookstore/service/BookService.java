package com.example.bookstore.service;


import com.example.bookstore.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> getAllBooks();
    public void saveBook(Book book);

    public Optional<Book> getBook(int id);
    public String deleteBook(int id);
}
