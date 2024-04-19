package com.example.bookEcommerce.configuration

import com.example.bookEcommerce.utils.constants.SwaggerConstant
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title(SwaggerConstant.TITLE)
                    .description(SwaggerConstant.DESCRIPTION)
                    .version(SwaggerConstant.VERSION)
                    .termsOfService(SwaggerConstant.TERM_OF_SERVICE_URL)
                    .license(
                        License()
                            .name(SwaggerConstant.CONTACT_VERSION)
                            .url(SwaggerConstant.CONTACT_URL_VERSION)
                    )
                    .contact(
                        Contact()
                            .name(SwaggerConstant.CONTACT_NAME)
                            .url(SwaggerConstant.CONTACT_URL)
                            .email(SwaggerConstant.CONTACT_EMAIL)
                    )
            )
            .components(
                Components()
                    .addSecuritySchemes(
                        "Authorization",
                        SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                            .`in`(SecurityScheme.In.HEADER)
                    )
            ).addSecurityItem(SecurityRequirement().addList("Authorization", listOf("read", "write")))
    }
}