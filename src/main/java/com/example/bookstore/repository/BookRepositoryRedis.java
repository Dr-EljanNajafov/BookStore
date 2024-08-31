package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryRedis {

    public static final String HASH_KEY = "Book";

    @Autowired
    private RedisTemplate template;

    public Book saveBook(Book book){
        template.opsForHash().put(HASH_KEY,String.valueOf(book.getBookId()),book);
        return book;
    }

    public List<Book> getAllBooks(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Book getBook(int id){
        System.out.println("called findBookById() from Redis");
        return (Book) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteBook(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "book removed !!";
    }
}
