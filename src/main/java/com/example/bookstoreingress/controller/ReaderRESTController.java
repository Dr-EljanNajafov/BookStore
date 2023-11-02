package com.example.bookstoreingress.controller;

import com.example.bookstoreingress.entity.Book;
import com.example.bookstoreingress.entity.Student;
import com.example.bookstoreingress.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderRESTController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/for-book/{bookId}")
    public ResponseEntity<List<Student>> getReadersForBook(@PathVariable Integer bookId) {

        List<Student> students = studentService.findReadersForBook(bookId);

        return ResponseEntity.ok(students);
    }
}
