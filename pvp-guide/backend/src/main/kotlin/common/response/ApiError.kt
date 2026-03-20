package com.vindev.pvpguide.common.response

import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    val message: String
)