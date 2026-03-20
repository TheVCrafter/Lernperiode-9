package com.vindev.pvpguide.features.kitvariants

import com.vindev.pvpguide.common.model.VersionGroup
import kotlinx.serialization.Serializable

@Serializable
data class KitVariant(
    val id: Long,
    val kitId: Long,
    val serverId: Long,
    val kitSlug: String,
    val serverSlug: String,
    val displayName: String,
    val versionGroup: VersionGroup,
    val ranked: Boolean,
    val rules: KitRuleFlags,
    val tagSlugs: List<String> = emptyList()
)