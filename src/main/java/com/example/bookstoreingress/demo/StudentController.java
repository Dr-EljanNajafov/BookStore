package com.example.bookstoreingress.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@Tag(name = "Student")
public class StudentController {


    @Operation(
            description = "Get endpoint for student",
            summary = "This is a summary for student get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }

    )
    @GetMapping
    public String get() {
        return "GET:: student controller";
    }
    @PostMapping
    public String post() {
        return "POST:: student controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: student controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: student controller";
    }
}
