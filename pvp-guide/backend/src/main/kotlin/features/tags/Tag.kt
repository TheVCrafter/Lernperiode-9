package com.vindev.pvpguide.features.tags

import com.vindev.pvpguide.common.model.TagType
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val id: Long,
    val slug: String,
    val name: String,
    val type: TagType
)