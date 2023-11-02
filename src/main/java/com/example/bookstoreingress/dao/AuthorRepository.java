package com.example.bookstoreingress.dao;


import com.example.bookstoreingress.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
