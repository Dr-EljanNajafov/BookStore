package com.example.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
public class BookRedis implements Serializable {

    private int bookId;
    private String name;

}
