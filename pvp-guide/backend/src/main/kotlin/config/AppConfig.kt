package com.vindev.pvpguide.config

import io.ktor.server.application.*
import io.ktor.server.config.*

data class AppConfig(
    val appName: String,
    val apiBasePath: String,
    val isDevelopment: Boolean,
    val corsHosts: List<String>,
    val corsSchemes: List<String>,
    val allowCredentials: Boolean
)

fun Application.loadAppConfig(): AppConfig {
    val config = environment.config

    return AppConfig(
        appName = config.propertyOrNull("app.name")?.getString()
            ?: "PvP Guide Backend",

        apiBasePath = config.propertyOrNull("app.api.basePath")?.getString()
            ?: "/api",

        isDevelopment = config.propertyOrNull("ktor.development")?.getString()?.toBooleanStrictOrNull()
            ?: false,

        corsHosts = config.propertyOrNull("app.cors.hosts")
            ?.getList()
            ?.filter { it.isNotBlank() }
            ?: emptyList(),

        corsSchemes = config.propertyOrNull("app.cors.schemes")
            ?.getList()
            ?.filter { it.isNotBlank() }
            ?: listOf("http"),

        allowCredentials = config.propertyOrNull("app.cors.allowCredentials")?.getString()?.toBooleanStrictOrNull()
            ?: false
    )
}