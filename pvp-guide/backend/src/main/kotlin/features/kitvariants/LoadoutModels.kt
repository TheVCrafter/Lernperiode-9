package com.vindev.pvpguide.features.kitvariants

import kotlinx.serialization.Serializable

@Serializable
enum class LoadoutPrecision {
    EXACT,
    PARTIAL,
    FLEXIBLE,
    UNKNOWN
}

@Serializable
enum class SourceReliability {
    OFFICIAL,
    COMMUNITY,
    MANUAL_CAPTURE
}

@Serializable
data class LoadoutSource(
    val label: String,
    val reliability: SourceReliability,
    val notes: String? = null
)

@Serializable
data class KitLoadoutItem(
    val slot: Int? = null,
    val itemKey: String,
    val amount: Int? = null,
    val enchantments: List<String> = emptyList(),
    val exactAmount: Boolean = true
)

@Serializable
data class KitLoadoutRule(
    val key: String,
    val value: String
)

@Serializable
data class KitLoadout(
    val precision: LoadoutPrecision,
    val items: List<KitLoadoutItem> = emptyList(),
    val rules: List<KitLoadoutRule> = emptyList(),
    val sources: List<LoadoutSource> = emptyList(),
    val notes: String? = null
)