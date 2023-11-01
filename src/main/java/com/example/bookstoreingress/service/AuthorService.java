package com.example.bookstoreingress.service;

import com.example.bookstoreingress.entity.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> getAllAuthors();
    public void saveAuthor(Author author);
    public  Author getAuthor(int id);
    public void deleteAuthor(int id);
}
