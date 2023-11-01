package com.example.bookstoreingress.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "author_books")
public class AuthorBooks {

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
