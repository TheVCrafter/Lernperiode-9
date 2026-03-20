package com.vindev.pvpguide.features.techniques

import com.vindev.pvpguide.common.response.ApiError
import com.vindev.pvpguide.common.util.parseDifficulty
import com.vindev.pvpguide.common.util.parseVersionGroup
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerTechniqueRoutes(
    techniqueRepository: TechniqueRepository
) {
    get("/techniques") {
        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])
        val difficulty = parseDifficulty(call.request.queryParameters["difficulty"])
        val tag = call.request.queryParameters["tag"]

        call.respond(
            techniqueRepository.getAll(
                versionGroup = versionGroup,
                difficulty = difficulty,
                tag = tag
            )
        )
    }

    get("/techniques/{slug}") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing technique slug"))

        val technique = techniqueRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Technique not found"))

        call.respond(technique)
    }
}