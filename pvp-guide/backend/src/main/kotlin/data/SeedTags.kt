package com.vindev.pvpguide.data

import com.vindev.pvpguide.common.model.TagType
import com.vindev.pvpguide.features.tags.Tag

object SeedTags {
    val tags = listOf(
        Tag(1, "movement", "Movement", TagType.SKILL),
        Tag(2, "neutral", "Neutral", TagType.TOPIC),
        Tag(3, "positioning", "Positioning", TagType.SKILL),
        Tag(4, "healing", "Healing", TagType.TOPIC),
        Tag(5, "consistency", "Consistency", TagType.SKILL),
        Tag(6, "hotbar", "Hotbar", TagType.SKILL),
        Tag(7, "shield", "Shield", TagType.TOPIC),
        Tag(8, "pressure", "Pressure", TagType.TOPIC),
        Tag(9, "mindgames", "Mindgames", TagType.SKILL),
        Tag(10, "crystal", "Crystal", TagType.KIT),
        Tag(11, "placement", "Placement", TagType.SKILL),
        Tag(12, "burst", "Burst", TagType.TOPIC),
        Tag(13, "projectiles", "Projectiles", TagType.TOPIC),
        Tag(14, "tempo", "Tempo", TagType.SKILL),
        Tag(15, "training", "Training", TagType.TRAINING),
        Tag(16, "kb-control", "KB Control", TagType.SKILL),
        Tag(17, "v1-8", "1.8+", TagType.VERSION),
        Tag(18, "v1-9", "1.9+", TagType.VERSION),
        Tag(19, "pot", "Pot", TagType.KIT),
        Tag(20, "axe-shield", "Axe & Shield", TagType.KIT),
        Tag(21, "uhc", "UHC", TagType.KIT),
        Tag(22, "sword", "Sword", TagType.KIT)
    )
}