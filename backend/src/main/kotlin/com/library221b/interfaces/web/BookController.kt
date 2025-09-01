package com.library221b.interfaces.web

import com.library221b.domain.book.RegisterBookCommand
import com.library221b.domain.book.RegisterBookPort
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.constraints.NotBlank
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Books")
@RestController
@RequestMapping("/api/books")
@Validated
class BookController(
    private val registerBook: RegisterBookPort
) {
    data class BookRequest(
        @field:NotBlank val title: String,
        val author: String?,
        val isbn: String?
    )

    data class BookResponse(
        val id: String,
        val title: String,
        val author: String?,
        val isbn: String?
    )

    @Operation(summary = "Register a new book")
    @PostMapping
    fun register(@RequestBody request: BookRequest): ResponseEntity<BookResponse> {
        val created = registerBook.register(RegisterBookCommand(
            title = request.title,
            author = request.author,
            isbn = request.isbn
        ))
        return ResponseEntity.ok(
            BookResponse(
                id = created.id.toString(),
                title = created.title,
                author = created.author,
                isbn = created.isbn
            )
        )
    }
}
