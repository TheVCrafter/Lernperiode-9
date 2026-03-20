package com.vindev.pvpguide.plugins

import com.vindev.pvpguide.config.AppConfig
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*

fun Application.configureHTTP(appConfig: AppConfig) {
    install(CORS) {
        if (appConfig.isDevelopment && appConfig.corsHosts.isEmpty()) {
            anyHost()
        } else {
            appConfig.corsHosts.forEach { host ->
                allowHost(
                    host = host,
                    schemes = appConfig.corsSchemes
                )
            }
        }

        allowCredentials = appConfig.allowCredentials

        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Patch)
        allowMethod(HttpMethod.Delete)

        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.Authorization)

        exposeHeader(HttpHeaders.Location)

        maxAgeInSeconds = 3600
    }
}