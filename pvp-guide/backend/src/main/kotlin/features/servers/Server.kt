package com.vindev.pvpguide.features.servers

import com.vindev.pvpguide.common.model.VersionGroup
import kotlinx.serialization.Serializable

@Serializable
data class Server(
    val id: Long,
    val slug: String,
    val name: String,
    val region: String,
    val active: Boolean,
    val supportedVersionGroups: List<VersionGroup> = emptyList()
)