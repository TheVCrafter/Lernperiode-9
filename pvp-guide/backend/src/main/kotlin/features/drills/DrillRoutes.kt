package com.vindev.pvpguide.features.drills

import com.vindev.pvpguide.common.response.ApiError
import com.vindev.pvpguide.common.util.parseDifficulty
import com.vindev.pvpguide.common.util.parseVersionGroup
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerDrillRoutes(
    drillRepository: DrillRepository
) {
    get("/drills") {
        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])
        val difficulty = parseDifficulty(call.request.queryParameters["difficulty"])
        val tag = call.request.queryParameters["tag"]

        call.respond(
            drillRepository.getAll(
                versionGroup = versionGroup,
                difficulty = difficulty,
                tag = tag
            )
        )
    }

    get("/drills/{slug}") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing drill slug"))

        val drill = drillRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Drill not found"))

        call.respond(drill)
    }
}