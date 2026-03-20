package com.vindev.pvpguide.features.mechanics

import com.vindev.pvpguide.common.model.VersionGroup

interface MechanicRepository {
    fun getAll(versionGroup: VersionGroup? = null, tag: String? = null): List<Mechanic>
    fun getBySlug(slug: String): Mechanic?
}