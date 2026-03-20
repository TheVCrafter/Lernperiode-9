package com.vindev.pvpguide.features.mechanics

import com.vindev.pvpguide.common.response.ApiError
import com.vindev.pvpguide.common.util.parseVersionGroup
import com.vindev.pvpguide.features.techniques.TechniqueRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerMechanicRoutes(
    mechanicRepository: MechanicRepository,
    techniqueRepository: TechniqueRepository
) {
    get("/mechanics") {
        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])
        val tag = call.request.queryParameters["tag"]

        call.respond(
            mechanicRepository.getAll(
                versionGroup = versionGroup,
                tag = tag
            )
        )
    }

    get("/mechanics/{slug}") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing mechanic slug"))

        val mechanic = mechanicRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Mechanic not found"))

        call.respond(mechanic)
    }

    get("/mechanics/{slug}/techniques") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing mechanic slug"))

        val mechanic = mechanicRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Mechanic not found"))

        call.respond(techniqueRepository.getByMechanicId(mechanic.id))
    }
}