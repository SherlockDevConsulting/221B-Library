package com.library221b.domain.health

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HealthCheckServiceTest {

    @Test
    fun `should return UP`() {
        val service = HealthCheckService()
        val result = service.check()
        assertEquals("UP", result["status"])
    }
}
