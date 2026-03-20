package com.vindev.pvpguide.features.kitvariants

import com.vindev.pvpguide.common.model.VersionGroup

class InMemoryKitVariantRepository(
    private val kitVariants: List<KitVariant>,
    private val loadouts: Map<Long, List<KitLoadoutItem>>
) : KitVariantRepository {

    override fun getAll(
        serverSlug: String?,
        kitSlug: String?,
        versionGroup: VersionGroup?
    ): List<KitVariant> {
        return kitVariants.filter { variant ->
            val serverMatches = serverSlug.isNullOrBlank() || variant.serverSlug.equals(serverSlug, ignoreCase = true)
            val kitMatches = kitSlug.isNullOrBlank() || variant.kitSlug.equals(kitSlug, ignoreCase = true)
            val versionMatches = versionGroup == null || variant.versionGroup == versionGroup
            serverMatches && kitMatches && versionMatches
        }
    }

    override fun getById(id: Long): KitVariant? {
        return kitVariants.firstOrNull { it.id == id }
    }

    override fun getRules(id: Long): KitRuleFlags? {
        return getById(id)?.rules
    }

    override fun getLoadout(id: Long): List<KitLoadoutItem>? {
        return loadouts[id]
    }

    override fun getByServerSlug(
        serverSlug: String,
        versionGroup: VersionGroup?,
        kitSlug: String?
    ): List<KitVariant> {
        return getAll(
            serverSlug = serverSlug,
            kitSlug = kitSlug,
            versionGroup = versionGroup
        )
    }

    override fun getByKitSlug(
        kitSlug: String,
        serverSlug: String?,
        versionGroup: VersionGroup?
    ): List<KitVariant> {
        return getAll(
            serverSlug = serverSlug,
            kitSlug = kitSlug,
            versionGroup = versionGroup
        )
    }
}