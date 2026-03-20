package com.vindev.pvpguide.plugins

import com.vindev.pvpguide.common.response.ApiError
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<BadRequestException> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest,
                ApiError(cause.message ?: "Bad request")
            )
        }

        exception<IllegalArgumentException> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest,
                ApiError(cause.message ?: "Invalid request")
            )
        }

        exception<NoSuchElementException> { call, cause ->
            call.respond(
                HttpStatusCode.NotFound,
                ApiError(cause.message ?: "Resource not found")
            )
        }

        status(HttpStatusCode.NotFound) { call, status ->
            call.respond(
                status,
                ApiError("Route not found")
            )
        }

        status(HttpStatusCode.MethodNotAllowed) { call, status ->
            call.respond(
                status,
                ApiError("Method not allowed")
            )
        }

        exception<Throwable> { call, cause ->
            call.application.log.error("Unhandled server error", cause)

            call.respond(
                HttpStatusCode.InternalServerError,
                ApiError("Internal server error")
            )
        }
    }
}