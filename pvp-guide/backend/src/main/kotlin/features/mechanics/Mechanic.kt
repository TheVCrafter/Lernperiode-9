package com.vindev.pvpguide.features.mechanics

import com.vindev.pvpguide.common.model.VersionGroup
import kotlinx.serialization.Serializable

@Serializable
data class Mechanic(
    val id: Long,
    val slug: String,
    val name: String,
    val summary: String,
    val details: String,
    val versionGroup: VersionGroup,
    val tagSlugs: List<String> = emptyList()
)