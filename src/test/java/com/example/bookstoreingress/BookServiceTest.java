package com.example.bookstoreingress;

import com.example.bookstoreingress.dao.BookRepository;
import com.example.bookstoreingress.dto.BookDTO;
import com.example.bookstoreingress.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReadingList() {
        // Mock data for the test
        int studentId = 1;
        List<BookDTO> expectedBooks = new ArrayList<>();
        expectedBooks.add(new BookDTO(1, "Book A"));
        expectedBooks.add(new BookDTO(2, "Book B"));

        // Define the behavior of the mock repository
        when(bookRepository.findBooksForStudent(studentId)).thenReturn(expectedBooks);

        // Call the service method
        List<BookDTO> actualBooks = bookService.getReadingList(studentId);

        // Verify the results
        assertEquals(expectedBooks.size(), actualBooks.size());
        assertEquals(expectedBooks, actualBooks);
    }

    // Add more test methods for other service operations
}

