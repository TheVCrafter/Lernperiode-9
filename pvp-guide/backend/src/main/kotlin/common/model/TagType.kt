package com.vindev.pvpguide.common.model

import kotlinx.serialization.Serializable

@Serializable
enum class TagType {
    SKILL,
    TOPIC,
    KIT,
    VERSION,
    TRAINING
}