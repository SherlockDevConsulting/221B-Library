package com.library221b.domain.health

/**
 * Primary port for health checking use case.
 */
fun interface HealthCheckPort {
    /** Returns a status map for health endpoint. */
    fun check(): Map<String, String>
}
