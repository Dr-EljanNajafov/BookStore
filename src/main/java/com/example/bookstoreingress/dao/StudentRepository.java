package com.example.bookstoreingress.dao;

import com.example.bookstoreingress.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s join s.books b where b.bookId = :bookId")
    List<Student> findByBooksId(@Param("bookId") int bookId);
}

