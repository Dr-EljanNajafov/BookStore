package com.example.bookstoreingress.dao;

import com.example.bookstoreingress.dto.BookDTO;
import com.example.bookstoreingress.entity.Book;
import com.example.bookstoreingress.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select new com.example.bookstoreingress.dto.BookDTO(b.bookId, b.name) from Book b join b.students s where s.studentId = :studentId")
    List<BookDTO> findBooksForStudent(@Param("studentId") int studentId);
}

