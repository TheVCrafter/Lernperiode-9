package com.vindev.pvpguide.data

import com.vindev.pvpguide.common.model.Difficulty
import com.vindev.pvpguide.common.model.VersionGroup
import com.vindev.pvpguide.features.drills.Drill
import com.vindev.pvpguide.features.mechanics.Mechanic
import com.vindev.pvpguide.features.techniques.Technique

object SeedLearning {

    val mechanics = listOf(
        Mechanic(
            id = 1,
            slug = "spacing",
            name = "Spacing",
            summary = "Managing distance so you can threaten hits while staying hard to punish.",
            details = "Spacing is one of the most important PvP fundamentals. It affects whether you get first hit control, safe disengages, or bad trades.",
            versionGroup = VersionGroup.V1_8_PLUS,
            tagSlugs = listOf("movement", "spacing", "v1-8")
        ),
        Mechanic(
            id = 2,
            slug = "inventory-discipline",
            name = "Inventory Discipline",
            summary = "Keeping your hotbar and healing flow under control during long fights.",
            details = "Inventory discipline matters most in potion-heavy or utility-heavy fights where panic swapping and bad hotbar structure can lose fights by themselves.",
            versionGroup = VersionGroup.V1_8_PLUS,
            tagSlugs = listOf("healing", "inventory-management", "v1-8")
        ),
        Mechanic(
            id = 3,
            slug = "shield-pressure",
            name = "Shield Pressure",
            summary = "Forcing defensive responses and punishing shield habits in modern melee.",
            details = "Shield pressure is a core 1.9+ mechanic. It is about forcing reactions, reading timing, and punishing predictable defense.",
            versionGroup = VersionGroup.V1_9_PLUS,
            tagSlugs = listOf("shield-play", "pressure", "v1-9")
        ),
        Mechanic(
            id = 4,
            slug = "crystal-placement",
            name = "Crystal Placement",
            summary = "Using safe placements, timing, and terrain to create explosive threat.",
            details = "Crystal placement is not only about speed. It is about safe angles, terrain control, and understanding when a placement creates real threat.",
            versionGroup = VersionGroup.V1_9_PLUS,
            tagSlugs = listOf("crystals", "pressure", "v1-9")
        ),
        Mechanic(
            id = 5,
            slug = "projectile-control",
            name = "Projectile Control",
            summary = "Using bows, rods, or crossbows to shape movement and tempo.",
            details = "Projectile control helps you set the pace of a fight by forcing movement, breaking rhythm, and opening melee entries.",
            versionGroup = VersionGroup.V1_8_PLUS,
            tagSlugs = listOf("aim", "projectiles", "v1-8")
        )
    )

    val techniques = listOf(
        Technique(
            id = 1,
            slug = "w-tap",
            name = "W-Tap",
            summary = "Reset sprint between hits to improve knockback control.",
            details = "W-tapping is about controlled sprint reset timing, not random key pressing. Done well, it improves pressure and first-hit quality.",
            difficulty = Difficulty.INTERMEDIATE,
            versionGroup = VersionGroup.V1_8_PLUS,
            mechanicIds = listOf(1),
            relatedKitVariantIds = listOf(101, 105),
            tagSlugs = listOf("movement", "spacing", "v1-8")
        ),
        Technique(
            id = 2,
            slug = "rod-pressure",
            name = "Rod Pressure",
            summary = "Use a fishing rod to force reactions and open a sword follow-up.",
            details = "Rod pressure works best when it creates a predictable response that you immediately convert into a sword entry.",
            difficulty = Difficulty.INTERMEDIATE,
            versionGroup = VersionGroup.V1_8_PLUS,
            mechanicIds = listOf(5),
            relatedKitVariantIds = listOf(101, 105),
            tagSlugs = listOf("aim", "projectiles", "v1-8")
        ),
        Technique(
            id = 3,
            slug = "pot-reset",
            name = "Pot Reset",
            summary = "Re-stabilize after damage by healing without losing all momentum.",
            details = "The goal is not just to heal fast, but to recover in a controlled way without throwing away your positioning.",
            difficulty = Difficulty.BEGINNER,
            versionGroup = VersionGroup.V1_8_PLUS,
            mechanicIds = listOf(2),
            relatedKitVariantIds = listOf(102),
            tagSlugs = listOf("healing", "inventory-management", "v1-8")
        ),
        Technique(
            id = 4,
            slug = "shield-bait",
            name = "Shield Bait",
            summary = "Provoke defensive shield usage and punish the timing window.",
            details = "Shield baiting is about reading defensive habits, creating false pressure, and punishing predictable timing.",
            difficulty = Difficulty.INTERMEDIATE,
            versionGroup = VersionGroup.V1_9_PLUS,
            mechanicIds = listOf(3),
            relatedKitVariantIds = listOf(203, 303, 403),
            tagSlugs = listOf("shield-play", "pressure", "v1-9")
        ),
        Technique(
            id = 5,
            slug = "safe-crystal-chain",
            name = "Safe Crystal Chain",
            summary = "String together safe placements and detonations without overcommitting.",
            details = "This technique focuses on maintaining threat while avoiding reckless placement patterns that expose you to counterplay.",
            difficulty = Difficulty.ADVANCED,
            versionGroup = VersionGroup.V1_9_PLUS,
            mechanicIds = listOf(4),
            relatedKitVariantIds = listOf(202, 301, 402),
            tagSlugs = listOf("crystals", "pressure", "v1-9")
        )
    )

    val drills = listOf(
        Drill(
            id = 1,
            slug = "w-tap-hit-confirm",
            name = "W-Tap Hit Confirm",
            summary = "Land 20 clean first hits in a row while focusing on spacing and sprint reset.",
            instructions = "Play short exchanges and only focus on clean sprint resets after confirmed hits. Ignore the duel result for this drill.",
            difficulty = Difficulty.INTERMEDIATE,
            versionGroup = VersionGroup.V1_8_PLUS,
            techniqueIds = listOf(1),
            relatedKitVariantIds = listOf(101, 105),
            tagSlugs = listOf("movement", "spacing", "drill")
        ),
        Drill(
            id = 2,
            slug = "rod-into-sword",
            name = "Rod into Sword Conversion",
            summary = "Practice rod contact into immediate sword follow-up for 10 repetitions per side.",
            instructions = "Repeat rod contact into one clean sword conversion from both directions. Focus on consistency, not style.",
            difficulty = Difficulty.INTERMEDIATE,
            versionGroup = VersionGroup.V1_8_PLUS,
            techniqueIds = listOf(2),
            relatedKitVariantIds = listOf(101, 105),
            tagSlugs = listOf("aim", "projectiles", "drill")
        ),
        Drill(
            id = 3,
            slug = "three-pot-recovery",
            name = "Three-Pot Recovery",
            summary = "Recover from disadvantage using only three healing pots and stable hotbar discipline.",
            instructions = "Start in disadvantage and allow yourself only three important healing decisions. The focus is recovery quality, not panic healing.",
            difficulty = Difficulty.BEGINNER,
            versionGroup = VersionGroup.V1_8_PLUS,
            techniqueIds = listOf(3),
            relatedKitVariantIds = listOf(102),
            tagSlugs = listOf("healing", "inventory-management", "drill")
        ),
        Drill(
            id = 4,
            slug = "shield-bait-punish-window",
            name = "Shield Bait Punish Window",
            summary = "Cycle shield pressure and punish the reaction without wasting openings.",
            instructions = "Alternate between pressure, pause, and punish. The drill fails if you attack without creating a real defensive response first.",
            difficulty = Difficulty.INTERMEDIATE,
            versionGroup = VersionGroup.V1_9_PLUS,
            techniqueIds = listOf(4),
            relatedKitVariantIds = listOf(203, 303, 403),
            tagSlugs = listOf("shield-play", "pressure", "drill")
        ),
        Drill(
            id = 5,
            slug = "double-place-disengage",
            name = "Double Place Disengage",
            summary = "Practice two safe crystal placements, disengage, and reset positioning.",
            instructions = "Place two controlled crystals, threaten detonation, then disengage and reset instead of forcing a greedy continuation.",
            difficulty = Difficulty.ADVANCED,
            versionGroup = VersionGroup.V1_9_PLUS,
            techniqueIds = listOf(5),
            relatedKitVariantIds = listOf(202, 301, 402),
            tagSlugs = listOf("crystals", "pressure", "drill")
        )
    )
}