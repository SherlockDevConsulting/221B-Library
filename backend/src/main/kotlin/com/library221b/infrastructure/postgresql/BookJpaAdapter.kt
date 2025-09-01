package com.library221b.infrastructure.postgresql

import com.library221b.domain.book.Book
import com.library221b.domain.book.BookRepositoryPort
import org.springframework.stereotype.Repository

@org.springframework.context.annotation.Profile("!test")
@Repository
class BookJpaAdapter(
    private val jpa: JpaBookRepository
) : BookRepositoryPort {
    override fun save(book: Book): Book {
        val entity = BookEntity(
            id = book.id,
            title = book.title,
            author = book.author,
            isbn = book.isbn
        )
        jpa.save(entity)
        return book
    }
}
