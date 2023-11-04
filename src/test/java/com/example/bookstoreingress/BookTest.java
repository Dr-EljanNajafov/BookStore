package com.example.bookstoreingress;

import com.example.bookstoreingress.entity.Author;
import com.example.bookstoreingress.entity.Book;
import com.example.bookstoreingress.entity.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void testCreateBook() {
        // Create a book instance
        Book book = new Book("Book Title");

        // Set the authors and students as needed
        List<Author> authors = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        book.setAuthors(authors);
        book.setStudents(students);

        // Add assertions to test the book properties
        assertEquals("Book Title", book.getName());
        assertEquals(authors, book.getAuthors());
        assertEquals(students, book.getStudents());
        // Add more assertions as needed
    }
}

