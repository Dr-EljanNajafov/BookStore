package com.example.bookstoreingress;

import com.example.bookstoreingress.dao.StudentRepository;
import com.example.bookstoreingress.entity.Student;
import com.example.bookstoreingress.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindReadersForBook() {
        // Mock data for the test
        int bookId = 1;
        List<Student> expectedStudents = new ArrayList<>();
        expectedStudents.add(new Student("El Na", 20));
        expectedStudents.add(new Student("Na El", 22));

        // Define the behavior of the mock repository
        when(studentRepository.findByBooksId(bookId)).thenReturn(expectedStudents);

        // Call the service method
        List<Student> actualStudents = studentService.findReadersForBook(bookId);

        // Verify the results
        assertEquals(expectedStudents.size(), actualStudents.size());
        assertEquals(expectedStudents, actualStudents);
    }

    // Add more test methods for other service operations
}

