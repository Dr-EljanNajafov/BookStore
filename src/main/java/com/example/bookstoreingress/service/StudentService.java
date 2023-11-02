package com.example.bookstoreingress.service;

import com.example.bookstoreingress.dao.BookRepository;
import com.example.bookstoreingress.dao.StudentRepository;
import com.example.bookstoreingress.entity.Book;
import com.example.bookstoreingress.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findReadersForBook(Integer bookId) {
        List<Student> students = studentRepository.findByBooksId(bookId);
        return students;
    }
}
