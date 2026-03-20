package com.vindev.pvpguide.common.model

import kotlinx.serialization.Serializable

@Serializable
enum class TargetType {
    MECHANIC,
    TECHNIQUE,
    DRILL,
    KIT,
    KIT_VARIANT,
    MATCHUP
}