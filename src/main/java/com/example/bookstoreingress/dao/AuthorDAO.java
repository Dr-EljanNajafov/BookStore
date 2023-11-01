package com.example.bookstoreingress.dao;


import com.example.bookstoreingress.entity.Author;

import java.util.List;

public interface AuthorDAO {
    public List<Author> getAllAuthors();

    public void saveAuthor(Author author);

    public Author getAuthor(int id);

    public void deleteAuthor(int id);
}
