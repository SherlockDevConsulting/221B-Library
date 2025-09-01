package com.library221b.infrastructure.postgresql

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "book")
class BookEntity(
    @Id
    var id: UUID,
    @Column(nullable = false)
    var title: String,
    var author: String?,
    var isbn: String?
) {
    // JPA requires a no-arg constructor
    constructor() : this(UUID.randomUUID(), "", null, null)
}
