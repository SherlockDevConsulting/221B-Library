package com.library221b.interfaces.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Health")
@RestController
@RequestMapping("/api/health")
class HealthController {
    @Operation(summary = "Simple health check")
    @GetMapping
    fun health(): ResponseEntity<Map<String, String>> = ResponseEntity.ok(mapOf("status" to "UP"))
}
