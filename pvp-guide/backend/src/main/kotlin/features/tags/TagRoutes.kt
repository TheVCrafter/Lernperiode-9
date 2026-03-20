package com.vindev.pvpguide.features.tags

import com.vindev.pvpguide.common.model.TagType
import com.vindev.pvpguide.common.util.parseVersionGroup
import com.vindev.pvpguide.common.response.ApiError
import com.vindev.pvpguide.features.drills.DrillRepository
import com.vindev.pvpguide.features.kits.KitRepository
import com.vindev.pvpguide.features.kitvariants.KitVariantRepository
import com.vindev.pvpguide.features.mechanics.MechanicRepository
import com.vindev.pvpguide.features.techniques.TechniqueRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registerTagRoutes(
    tagRepository: TagRepository,
    mechanicRepository: MechanicRepository,
    techniqueRepository: TechniqueRepository,
    drillRepository: DrillRepository,
    kitRepository: KitRepository,
    kitVariantRepository: KitVariantRepository
) {
    get("/tags") {
        val type = call.request.queryParameters["type"]
            ?.trim()
            ?.uppercase()
            ?.let { runCatching { TagType.valueOf(it) }.getOrNull() }

        call.respond(tagRepository.getAll(type = type))
    }

    get("/tags/{id}/content") {
        val id = call.parameters["id"]?.toLongOrNull()
            ?: return@get call.respond(HttpStatusCode.BadRequest, ApiError("Invalid tag id"))

        val tag = tagRepository.getById(id)
            ?: return@get call.respond(HttpStatusCode.NotFound, ApiError("Tag not found"))

        val versionGroup = parseVersionGroup(call.request.queryParameters["versionGroup"])

        val mechanics = mechanicRepository
            .getAll(versionGroup = versionGroup, tag = tag.slug)

        val techniques = techniqueRepository
            .getAll(versionGroup = versionGroup, difficulty = null, tag = tag.slug)

        val drills = drillRepository
            .getAll(versionGroup = versionGroup, difficulty = null, tag = tag.slug)

        val kits = kitRepository
            .getAll(versionGroup = versionGroup)
            .filter { tag.slug in it.tagSlugs }

        val kitVariants = kitVariantRepository
            .getAll(versionGroup = versionGroup)
            .filter { tag.slug in it.tagSlugs }

        call.respond(
            TagContentResponse(
                tag = tag,
                mechanics = mechanics,
                techniques = techniques,
                drills = drills,
                kits = kits,
                kitVariants = kitVariants
            )
        )
    }
}