package com.vindev.pvpguide.features.techniques

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup

class InMemoryTechniqueRepository(
    private val techniques: List<Technique>
) : TechniqueRepository {

    override fun getAll(
        versionGroup: VersionGroup?,
        difficulty: Difficulty?,
        tag: String?
    ): List<Technique> {
        return techniques.filter { technique ->
            val versionMatches = versionGroup == null || technique.versionGroup == versionGroup
            val difficultyMatches = difficulty == null || technique.difficulty == difficulty
            val tagMatches = tag.isNullOrBlank() || technique.tagSlugs.any { it.equals(tag, ignoreCase = true) }

            versionMatches && difficultyMatches && tagMatches
        }
    }

    override fun getBySlug(slug: String): Technique? {
        return techniques.firstOrNull { it.slug.equals(slug, ignoreCase = true) }
    }

    override fun getByMechanicId(mechanicId: Long): List<Technique> {
        return techniques.filter { mechanicId in it.mechanicIds }
    }

    override fun getByKitVariantId(kitVariantId: Long): List<Technique> {
        return techniques.filter { kitVariantId in it.relatedKitVariantIds }
    }
}