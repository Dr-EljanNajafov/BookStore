package com.example.bookstoreingress.dao;

import com.example.bookstoreingress.entity.Author;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Author> getAllAuthors() {
        Session session = entityManager.unwrap(Session.class);

        List<Author> allAuthors = session.createQuery("from Author ", Author.class).getResultList();

        return allAuthors;
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(author);
    }

    @Override
    public Author getAuthor(int id) {
        Session session = entityManager.unwrap(Session.class);
        Author author = session.get(Author.class, id);
        return author;
    }

    @Override
    public void deleteAuthor(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Author> query = session.createQuery("delete from Author where id =:authorId");
        query.setParameter("authorId", id);
        query.executeUpdate();
    }
}
