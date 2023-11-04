package com.example.bookstoreingress;

import com.example.bookstoreingress.entity.Author;
import com.example.bookstoreingress.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthorStudentEntityTests {

    @Test
    public void testAuthorEntity() {
        Author author = new Author("El Na", 35);
        assertEquals("El Na", author.getName());
        assertEquals(35, author.getAge());
        // Add more assertions as needed
    }

    @Test
    public void testStudentEntity() {
        Student student = new Student("El Na", 20);
        assertEquals("El Na", student.getName());
        assertEquals(20, student.getAge());
        // Add more assertions as needed
    }
}
