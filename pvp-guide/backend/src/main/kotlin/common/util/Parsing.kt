package com.vindev.pvpguide.common.util

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup

fun parseVersionGroup(value: String?): VersionGroup? {
    return value
        ?.trim()
        ?.uppercase()
        ?.let { runCatching { VersionGroup.valueOf(it) }.getOrNull() }
}

fun parseBoolean(value: String?): Boolean? {
    return when (value?.trim()?.lowercase()) {
        "true" -> true
        "false" -> false
        else -> null
    }
}

fun parseDifficulty(value: String?): Difficulty? {
    return value
        ?.trim()
        ?.uppercase()
        ?.let { runCatching { Difficulty.valueOf(it) }.getOrNull() }
}