package com.vindev.pvpguide.features.techniques

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup
import kotlinx.serialization.Serializable

@Serializable
data class Technique(
    val id: Long,
    val slug: String,
    val name: String,
    val summary: String,
    val details: String,
    val difficulty: Difficulty,
    val versionGroup: VersionGroup,
    val mechanicIds: List<Long> = emptyList(),
    val relatedKitVariantIds: List<Long> = emptyList(),
    val tagSlugs: List<String> = emptyList()
)