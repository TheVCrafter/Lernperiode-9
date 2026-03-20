package com.vindev.pvpguide.features.drills

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup

class InMemoryDrillRepository(
    private val drills: List<Drill>
) : DrillRepository {

    override fun getAll(
        versionGroup: VersionGroup?,
        difficulty: Difficulty?,
        tag: String?
    ): List<Drill> {
        return drills.filter { drill ->
            val versionMatches = versionGroup == null || drill.versionGroup == versionGroup
            val difficultyMatches = difficulty == null || drill.difficulty == difficulty
            val tagMatches = tag.isNullOrBlank() || drill.tagSlugs.any { it.equals(tag, ignoreCase = true) }

            versionMatches && difficultyMatches && tagMatches
        }
    }

    override fun getBySlug(slug: String): Drill? {
        return drills.firstOrNull { it.slug.equals(slug, ignoreCase = true) }
    }

    override fun getByTechniqueId(techniqueId: Long): List<Drill> {
        return drills.filter { techniqueId in it.techniqueIds }
    }

    override fun getByKitVariantId(kitVariantId: Long): List<Drill> {
        return drills.filter { kitVariantId in it.relatedKitVariantIds }
    }
}