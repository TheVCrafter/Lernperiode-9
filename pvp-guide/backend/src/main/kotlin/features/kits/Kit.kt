package com.vindev.pvpguide.features.kits

import com.vindev.pvpguide.common.model.VersionGroup
import kotlinx.serialization.Serializable

@Serializable
data class Kit(
    val id: Long,
    val slug: String,
    val name: String,
    val description: String,
    val versionGroup: VersionGroup,
    val tagSlugs: List<String> = emptyList()
)