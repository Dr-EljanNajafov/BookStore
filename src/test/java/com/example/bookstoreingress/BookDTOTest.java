package com.example.bookstoreingress;

import com.example.bookstoreingress.dto.BookDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookDTOTest {

    @Test
    public void testBookDTOConstruction() {
        int bookId = 1;
        String name = "Sample Book";

        BookDTO bookDTO = new BookDTO(bookId, name);

        assertEquals(bookId, bookDTO.getBookId());
        assertEquals(name, bookDTO.getName());
    }

    @Test
    public void testBookDTOSettersAndGetters() {
        int bookId = 2;
        String name = "Another Book";

        BookDTO bookDTO = new BookDTO(1, "Sample Book");

        // Use setters to change the values
        bookDTO.setBookId(bookId);
        bookDTO.setName(name);

        assertEquals(bookId, bookDTO.getBookId());
        assertEquals(name, bookDTO.getName());
    }
}

