package com.vindev.pvpguide.features.kits

import com.vindev.pvpguide.common.response.ApiError
import com.vindev.pvpguide.common.util.parseVersionGroup
import com.vindev.pvpguide.features.kitvariants.KitVariantRepository
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerKitRoutes(
    kitRepository: KitRepository,
    kitVariantRepository: KitVariantRepository
) {
    get("/kits") {
        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])
        call.respond(kitRepository.getAll(versionGroup = versionGroup))
    }

    get("/kits/{slug}") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing kit slug"))

        val kit = kitRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Kit not found"))

        call.respond(kit)
    }

    get("/kits/{slug}/variants") {
        val slug = call.parameters["slug"]
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Missing kit slug"))

        val kit = kitRepository.getBySlug(slug)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Kit not found"))

        val serverSlug = call.request.queryParameters["server"]
        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])

        val variants = kitVariantRepository.getByKitSlug(
            kitSlug = kit.slug,
            serverSlug = serverSlug,
            versionGroup = versionGroup
        )

        call.respond(variants)
    }
}