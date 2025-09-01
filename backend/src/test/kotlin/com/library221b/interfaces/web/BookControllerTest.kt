package com.library221b.interfaces.web

import com.library221b.domain.book.RegisterBookPort
import com.library221b.domain.book.Book
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.ArgumentMatchers.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var registerBookPort: RegisterBookPort

    @Test
    fun `should register a book`() {
        val id = UUID.randomUUID()
        given(registerBookPort.register(any())).willReturn(Book(id = id, title = "Sherlock", author = "AC Doyle", isbn = "123"))

        mockMvc.post("/api/books") {
            contentType = MediaType.APPLICATION_JSON
            content = "{""title"":""Sherlock"",""author"":""AC Doyle"",""isbn"":""123""}"
        }.andExpect {
            status { isOk() }
            jsonPath("$.id") { value(id.toString()) }
            jsonPath("$.title") { value("Sherlock") }
        }
    }
}
