package com.library221b.domain.book

import java.util.*

/** Primary port: use case to register a book */
fun interface RegisterBookPort {
    fun register(command: RegisterBookCommand): Book
}

/** Secondary port: persistence of books */
fun interface BookRepositoryPort {
    fun save(book: Book): Book
}

data class RegisterBookCommand(
    val title: String,
    val author: String?,
    val isbn: String?
)
