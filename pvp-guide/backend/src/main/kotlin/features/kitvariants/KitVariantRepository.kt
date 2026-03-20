package com.vindev.pvpguide.features.kitvariants

import com.vindev.pvpguide.common.model.VersionGroup

interface KitVariantRepository {
    fun getAll(
        serverSlug: String? = null,
        kitSlug: String? = null,
        versionGroup: VersionGroup? = null
    ): List<KitVariant>

    fun getById(id: Long): KitVariant?

    fun getRules(id: Long): KitRuleFlags?

    fun getLoadout(id: Long): List<KitLoadoutItem>?

    fun getByServerSlug(
        serverSlug: String,
        versionGroup: VersionGroup? = null,
        kitSlug: String? = null
    ): List<KitVariant>

    fun getByKitSlug(
        kitSlug: String,
        serverSlug: String? = null,
        versionGroup: VersionGroup? = null
    ): List<KitVariant>
}