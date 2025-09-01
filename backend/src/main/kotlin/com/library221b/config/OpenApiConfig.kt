package com.library221b.config

import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springdoc.core.models.OpenAPI as SpringDocOpenAPI

@Configuration
class OpenApiConfig {
    @Bean
    fun publicApi(): GroupedOpenApi = GroupedOpenApi.builder()
        .group("public")
        .pathsToMatch("/api/**")
        .build()

    @Bean
    fun openAPI(): SpringDocOpenAPI = SpringDocOpenAPI()
        .info(
            Info()
                .title("221B Library API")
                .description("Backend API for 221B Library")
                .version("0.0.1")
                .license(License().name("MIT"))
        )
}
