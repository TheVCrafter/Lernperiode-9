package com.vindev.pvpguide.features.health

import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerHealthRoutes() {
    get("/health") {
        call.respond(HealthResponse(status = "ok"))
    }
}