package com.library221b.infrastructure.postgresql

import com.library221b.domain.book.Book
import com.library221b.domain.book.BookRepositoryPort
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@org.springframework.context.annotation.Profile("jdbc")
@Repository
class BookJdbcRepository(
    private val jdbc: NamedParameterJdbcTemplate
) : BookRepositoryPort {
    override fun save(book: Book): Book {
        val sql = """
            INSERT INTO book (id, title, author, isbn, created_at)
            VALUES (:id, :title, :author, :isbn, NOW())
        """.trimIndent()
        val params = MapSqlParameterSource()
            .addValue("id", book.id)
            .addValue("title", book.title)
            .addValue("author", book.author)
            .addValue("isbn", book.isbn)
        jdbc.update(sql, params)
        return book
    }
}
