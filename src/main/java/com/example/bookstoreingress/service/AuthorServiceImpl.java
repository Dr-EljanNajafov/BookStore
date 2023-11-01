package com.example.bookstoreingress.service;


import com.example.bookstoreingress.dao.AuthorDAO;
import com.example.bookstoreingress.entity.Author;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.saveAuthor(author);
    }

    @Override
    @Transactional
    public Author getAuthor(int id) {
        return authorDAO.getAuthor(id);
    }

    @Override
    @Transactional
    public void deleteAuthor(int id) {
        authorDAO.deleteAuthor(id);
    }
}
