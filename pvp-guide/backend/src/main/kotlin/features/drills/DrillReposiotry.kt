package com.vindev.pvpguide.features.drills

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup

interface DrillRepository {
    fun getAll(
        versionGroup: VersionGroup? = null,
        difficulty: Difficulty? = null,
        tag: String? = null
    ): List<Drill>

    fun getBySlug(slug: String): Drill?
    fun getByTechniqueId(techniqueId: Long): List<Drill>
    fun getByKitVariantId(kitVariantId: Long): List<Drill>
}