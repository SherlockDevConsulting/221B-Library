package com.library221b.domain.book

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class RegisterBookServiceTest {

    private val repo = mockk<BookRepositoryPort>()
    private val service = RegisterBookService(repo)

    @Test
    fun `should require non blank title`() {
        assertThrows(IllegalArgumentException::class.java) {
            service.register(RegisterBookCommand(title = "  ", author = null, isbn = null))
        }
    }

    @Test
    fun `should trim fields and delegate to repository`() {
        every { repo.save(any()) } answers { firstArg() }
        val created = service.register(RegisterBookCommand(title = "  Title  ", author = "  A ", isbn = " "))
        assertEquals("Title", created.title)
        assertEquals("A", created.author)
        assertEquals(null, created.isbn)
    }
}
