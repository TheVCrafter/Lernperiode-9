package com.vindev.pvpguide.features.techniques

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup

interface TechniqueRepository {
    fun getAll(
        versionGroup: VersionGroup? = null,
        difficulty: Difficulty? = null,
        tag: String? = null
    ): List<Technique>

    fun getBySlug(slug: String): Technique?
    fun getByMechanicId(mechanicId: Long): List<Technique>
    fun getByKitVariantId(kitVariantId: Long): List<Technique>
}