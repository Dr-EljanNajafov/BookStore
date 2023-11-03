package com.example.bookstoreingress.demo;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
@PreAuthorize("hasRole('AUTHOR')")
public class AuthorController {

    @GetMapping
    @PreAuthorize("hasAuthority('author:read')")
    public String get() {
        return "GET:: author controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('author:create')")
    @Hidden
    public String post() {
        return "POST:: author controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('author:update')")
    @Hidden
    public String put() {
        return "PUT:: author controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('author:delete')")
    @Hidden
    public String delete() {
        return "DELETE:: author controller";
    }
}
