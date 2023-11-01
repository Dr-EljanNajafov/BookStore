package com.example.bookstoreingress.controller;

import com.example.bookstoreingress.entity.Author;
import com.example.bookstoreingress.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthorRESTController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> showAllAuthors() {
        List<Author> allAuthors = authorService.getAllAuthors();
        return allAuthors;
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int id) {
        Author author = authorService.getAuthor(id);
        return author;
    }

    @PostMapping("/authors")
    public Author addNewAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return author;
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return author;
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
