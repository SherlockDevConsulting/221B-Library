package com.library221b.domain.health

import org.springframework.stereotype.Service

/**
 * Simple domain service implementing the HealthCheckPort use case.
 * In a strict hexagonal setup this class would be pure and wired by configuration.
 * We pragmatically annotate it as a Spring service for brevity.
 */
@Service
class HealthCheckService : HealthCheckPort {
    override fun check(): Map<String, String> = mapOf("status" to "UP")
}
