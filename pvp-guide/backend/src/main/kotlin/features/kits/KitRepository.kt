package com.vindev.pvpguide.features.kits

import com.vindev.pvpguide.common.model.VersionGroup

interface KitRepository {
    fun getAll(versionGroup: VersionGroup? = null): List<Kit>
    fun getBySlug(slug: String): Kit?
}