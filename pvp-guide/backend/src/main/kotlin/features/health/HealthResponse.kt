package com.vindev.pvpguide.features.health

import kotlinx.serialization.Serializable

@Serializable
data class HealthResponse(
    val status: String
)