package com.library221b.infrastructure

import com.library221b.domain.book.BookRepositoryPort
import com.library221b.domain.book.RegisterBookPort
import com.library221b.domain.book.RegisterBookService
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BookBeansConfig {
    @Bean
    @ConditionalOnMissingBean(RegisterBookPort::class)
    fun registerBookPort(repo: BookRepositoryPort): RegisterBookPort = RegisterBookService(repo)
}
