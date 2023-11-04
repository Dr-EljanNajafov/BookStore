package com.example.bookstoreingress;

import com.example.bookstoreingress.dao.AuthorRepository;
import com.example.bookstoreingress.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testSaveAuthor() {
        Author author = new Author("El Na", 35);
        authorRepository.save(author);

        // Verify that the author was saved and has an ID assigned
        assertTrue(author.getAuthorId() > 0);
    }

    @Test
    public void testFindAuthorById() {
        Author author = new Author("El Na", 40);
        authorRepository.save(author);

        Optional<Author> foundAuthor = authorRepository.findById(author.getAuthorId());

        assertTrue(foundAuthor.isPresent());
        assertEquals(author.getAuthorId(), foundAuthor.get().getAuthorId());
    }

    @Test
    public void testFindAllAuthors() {
        Author author1 = new Author("El Na", 30);
        Author author2 = new Author("Na El", 45);
        authorRepository.save(author1);
        authorRepository.save(author2);

        List<Author> authors = authorRepository.findAll();

        // Verify that both authors were saved and retrieved
        assertEquals(2, authors.size());
    }

    @Test
    public void testDeleteAuthor() {
        Author author = new Author("An Le", 28);
        authorRepository.save(author);

        authorRepository.deleteById(author.getAuthorId());

        // Verify that the author was deleted
        assertTrue(authorRepository.findById(author.getAuthorId()).isEmpty());
    }
}
