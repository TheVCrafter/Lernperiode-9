package com.vindev.pvpguide.features.kitvariants

import kotlinx.serialization.Serializable

@Serializable
data class KitRuleFlags(
    val healingAllowed: Boolean,
    val crystalsAllowed: Boolean,
    val shieldsAllowed: Boolean,
    val lavaAllowed: Boolean,
    val bowsAllowed: Boolean
)