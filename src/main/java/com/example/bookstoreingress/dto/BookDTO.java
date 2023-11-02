package com.example.bookstoreingress.dto;

import lombok.Data;

@Data
public class BookDTO {
    private int bookId;
    private String name;

    public BookDTO(int bookId, String name) {
        this.bookId = bookId;
        this.name = name;
    }
}
