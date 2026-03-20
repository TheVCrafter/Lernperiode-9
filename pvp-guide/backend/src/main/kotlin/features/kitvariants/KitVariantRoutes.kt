package com.vindev.pvpguide.features.kitvariants

import com.vindev.pvpguide.common.response.ApiError
import com.vindev.pvpguide.common.util.parseVersionGroup
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerKitVariantRoutes(
    kitVariantRepository: KitVariantRepository
) {
    get("/kit-variants") {
        val serverSlug = call.request.queryParameters["server"]
        val kitSlug = call.request.queryParameters["kit"]
        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])

        val variants = kitVariantRepository.getAll(
            serverSlug = serverSlug,
            kitSlug = kitSlug,
            versionGroup = versionGroup
        )

        call.respond(variants)
    }

    get("/kit-variants/{id}") {
        val id = call.parameters["id"]?.toLongOrNull()
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Invalid kit variant id"))

        val variant = kitVariantRepository.getById(id)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Kit variant not found"))

        call.respond(variant)
    }

    get("/kit-variants/{id}/rules") {
        val id = call.parameters["id"]?.toLongOrNull()
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Invalid kit variant id"))

        val rules = kitVariantRepository.getRules(id)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Kit variant not found"))

        call.respond(rules)
    }

    get("/kit-variants/{id}/loadout") {
        val id = call.parameters["id"]?.toLongOrNull()
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Invalid kit variant id"))

        val loadout = kitVariantRepository.getLoadout(id)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Kit variant not found"))

        call.respond(loadout)
    }
}