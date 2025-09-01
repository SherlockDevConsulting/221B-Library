package com.library221b.domain.book

/** Domain service implementing the register book use case. */
class RegisterBookService(
    private val repository: BookRepositoryPort
) : RegisterBookPort {
    override fun register(command: RegisterBookCommand): Book {
        require(command.title.isNotBlank()) { "title must not be blank" }
        val book = Book(
            title = command.title.trim(),
            author = command.author?.trim()?.ifBlank { null },
            isbn = command.isbn?.trim()?.ifBlank { null }
        )
        return repository.save(book)
    }
}
