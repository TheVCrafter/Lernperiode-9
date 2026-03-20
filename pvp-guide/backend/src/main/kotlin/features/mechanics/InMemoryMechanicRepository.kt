package com.vindev.pvpguide.features.mechanics

import com.vindev.pvpguide.common.model.VersionGroup

class InMemoryMechanicRepository(
    private val mechanics: List<Mechanic>
) : MechanicRepository {

    override fun getAll(versionGroup: VersionGroup?, tag: String?): List<Mechanic> {
        return mechanics.filter { mechanic ->
            val versionMatches = versionGroup == null || mechanic.versionGroup == versionGroup
            val tagMatches = tag.isNullOrBlank() || mechanic.tagSlugs.any { it.equals(tag, ignoreCase = true) }
            versionMatches && tagMatches
        }
    }

    override fun getBySlug(slug: String): Mechanic? {
        return mechanics.firstOrNull { it.slug.equals(slug, ignoreCase = true) }
    }
}