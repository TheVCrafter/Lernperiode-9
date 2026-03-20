package com.vindev.pvpguide.features.servers

import com.vindev.pvpguide.common.response.ApiError
import com.vindev.pvpguide.common.util.parseBoolean
import com.vindev.pvpguide.common.util.parseVersionGroup
import com.vindev.pvpguide.features.kitvariants.KitVariantRepository
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerServerRoutes(
    serverRepository: ServerRepository,
    kitVariantRepository: KitVariantRepository
) {
    get("/servers") {
        val active = parseBoolean(call.request.queryParameters["active"])
        val region = call.request.queryParameters["region"]

        call.respond(serverRepository.getAll(active = active, region = region))
    }

    get("/servers/{slug}") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing server slug"))

        val server = serverRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Server not found"))

        call.respond(server)
    }

    get("/servers/{slug}/kit-variants") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing server slug"))

        val server = serverRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Server not found"))

        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])
        val kitSlug = call.request.queryParameters["kitSlug"]

        val variants = kitVariantRepository.getByServerSlug(
            serverSlug = server.slug,
            versionGroup = versionGroup,
            kitSlug = kitSlug
        )

        call.respond(variants)
    }
}