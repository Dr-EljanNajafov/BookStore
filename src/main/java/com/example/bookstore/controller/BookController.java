package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepositoryRedis;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@EnableCaching
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepositoryRedis bookRepositoryRedis;

    @GetMapping("/books")
    public List<Book> showAllBooks() {
        bookRepositoryRedis.getAllBooks();
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    @Cacheable(key = "#id",value = "Book")
    public Optional<Book> getBook(@PathVariable int id) {
        bookRepositoryRedis.getBook(id);
        return bookService.getBook(id);
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book) {
        bookRepositoryRedis.saveBook(book);
        bookService.saveBook(book);
        return book;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    @CacheEvict(key = "#id",value = "Book")
    public String deleteBook(@PathVariable int id) {
        bookRepositoryRedis.deleteBook(id);
        return bookService.deleteBook(id);
    }
}
