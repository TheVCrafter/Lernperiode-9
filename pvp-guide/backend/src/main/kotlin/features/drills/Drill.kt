package com.vindev.pvpguide.features.drills

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup
import kotlinx.serialization.Serializable

@Serializable
data class Drill(
    val id: Long,
    val slug: String,
    val name: String,
    val summary: String,
    val instructions: String,
    val difficulty: Difficulty,
    val versionGroup: VersionGroup,
    val techniqueIds: List<Long> = emptyList(),
    val relatedKitVariantIds: List<Long> = emptyList(),
    val tagSlugs: List<String> = emptyList()
)