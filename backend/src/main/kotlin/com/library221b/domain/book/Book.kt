package com.library221b.domain.book

import java.util.*

/** Domain model for a Book. */
data class Book(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val author: String?,
    val isbn: String?
)
