package com.library221b.infrastructure.postgresql

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface JpaBookRepository : JpaRepository<BookEntity, UUID>
