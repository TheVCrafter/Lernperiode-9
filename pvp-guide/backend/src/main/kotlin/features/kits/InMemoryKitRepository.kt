package com.vindev.pvpguide.features.kits

import com.vindev.pvpguide.common.model.VersionGroup

class InMemoryKitRepository(
    private val kits: List<Kit>
) : KitRepository {

    override fun getAll(versionGroup: VersionGroup?): List<Kit> {
        return kits.filter { kit ->
            versionGroup == null || kit.versionGroup == versionGroup
        }
    }

    override fun getBySlug(slug: String): Kit? {
        return kits.firstOrNull { it.slug.equals(slug, ignoreCase = true) }
    }
}