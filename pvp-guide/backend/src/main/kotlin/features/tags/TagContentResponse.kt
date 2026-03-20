package com.vindev.pvpguide.features.tags

import com.vindev.pvpguide.features.drills.Drill
import com.vindev.pvpguide.features.kits.Kit
import com.vindev.pvpguide.features.kitvariants.KitVariant
import com.vindev.pvpguide.features.mechanics.Mechanic
import com.vindev.pvpguide.features.techniques.Technique
import kotlinx.serialization.Serializable

@Serializable
data class TagContentResponse(
    val tag: Tag,
    val mechanics: List<Mechanic> = emptyList(),
    val techniques: List<Technique> = emptyList(),
    val drills: List<Drill> = emptyList(),
    val kits: List<Kit> = emptyList(),
    val kitVariants: List<KitVariant> = emptyList()
)