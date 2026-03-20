package com.vindev.pvpguide.data

import com.vindev.pvpguide.features.kitvariants.KitLoadout
import com.vindev.pvpguide.features.kitvariants.KitLoadoutItem
import com.vindev.pvpguide.features.kitvariants.KitLoadoutRule
import com.vindev.pvpguide.features.kitvariants.LoadoutPrecision
import com.vindev.pvpguide.features.kitvariants.LoadoutSource
import com.vindev.pvpguide.features.kitvariants.SourceReliability

object SeedLoadouts {

    val templateLoadoutsByKitSlug: Map<String, KitLoadout> = mapOf(
        "pot" to exact(
            source = official("PvPTiers Pot PvP"),
            notes = "Universal competitive Pot kit template.",
            items = listOf(
                item("steak", 20),
                item("splash_potion_of_healing_ii", 24),
                item("potion_of_strength_ii_90s", 3),
                item("potion_of_swiftness_ii_90s", 3),
                item("potion_of_regeneration_i_90s", 3),
                item("diamond_sword", 1, "sharpness_5"),
                item("bow", 1, "power_5", "punch_2"),
                item("diamond_helmet", 1, "protection_4", "unbreaking_3"),
                item("diamond_chestplate", 1, "protection_4", "unbreaking_3"),
                item("diamond_leggings", 1, "protection_4", "unbreaking_3"),
                item("diamond_boots", 1, "protection_4", "unbreaking_3")
            )
        ),

        "netherite-pot" to exact(
            source = official("PvPTiers Netherite Pot PvP"),
            notes = "Universal competitive Netherite Pot kit template.",
            items = listOf(
                item("totem_of_undying", 3),
                item("experience_bottle", 128),
                item("golden_apple", 64),
                item("splash_potion_of_healing_ii", 15),
                item("splash_potion_of_strength_ii", 6),
                item("splash_potion_of_swiftness_ii", 6),
                item("splash_potion_of_fire_resistance", 3),
                item("netherite_sword", 1, "sharpness_5", "fire_aspect_2"),
                item("netherite_helmet", 1, "protection_4", "unbreaking_3", "mending"),
                item("netherite_chestplate", 1, "protection_4", "unbreaking_3", "mending"),
                item("netherite_leggings", 1, "protection_4", "unbreaking_3", "mending"),
                item("netherite_boots", 1, "protection_4", "unbreaking_3", "mending")
            )
        ),

        "axe-shield" to exact(
            source = official("PvPTiers Axe PvP"),
            notes = "Universal competitive Axe PvP test kit.",
            items = listOf(
                item("diamond_axe", 1),
                item("diamond_sword", 1),
                item("shield", 1),
                item("crossbow", 1),
                item("bow", 1),
                item("arrow", 6),
                item("diamond_helmet", 1),
                item("diamond_chestplate", 1),
                item("diamond_leggings", 1),
                item("diamond_boots", 1)
            )
        ),

        "crystal" to flexible(
            source = official("PvPTiers Crystal PvP"),
            notes = "Crystal PvP is intentionally not a fixed inventory. Use rules and limits instead of pretending exact slots/counts are universal.",
            rules = listOf(
                rule("mandatory_item", "respawn_anchor"),
                rule("mandatory_item", "glowstone"),
                rule("mandatory_item", "end_crystal"),
                rule("mandatory_item", "obsidian"),
                rule("mandatory_item", "ender_chest"),
                rule("mandatory_item", "experience_bottle"),
                rule("mandatory_item", "totem_of_undying"),
                rule("mandatory_item", "ender_pearl"),
                rule("limit_lt3_totems", "14"),
                rule("limit_ht3_plus_totems", "8"),
                rule("limit_respawn_anchors", "64"),
                rule("limit_firework_rockets", "64"),
                rule("limit_elytra", "1"),
                rule("limit_armor_pieces", "4"),
                rule("banned_item", "milk_bucket"),
                rule("banned_item", "enchanted_golden_apple"),
                rule("banned_item", "potion_of_the_turtle_master"),
                rule("banned_item", "shovel"),
                rule("banned_item", "mace"),
                rule("banned_item", "weakness_arrow")
            )
        ),

        "mace" to unknown(
            source = official("PvPTiers Mace PvP"),
            notes = "Testing kit is listed as 'Soon', so do not hardcode a fake inventory yet."
        ),

        "sword" to unknown(
            source = community("PvPTiers Sword PvP"),
            notes = "Current public page exposes rules and testing structure, but not a fixed testing kit in the parsed text."
        ),

        "uhc-duels" to unknown(
            source = community("PvPTiers UHC Kit PvP"),
            notes = "Use server-specific overrides for now. The parsed public page does not expose a universal fixed testing kit."
        ),

        "classic" to unknown(
            source = official("Minemen Club"),
            notes = "Ladder exists publicly, but exact inventory is not exposed on the public site."
        ),

        "nodebuff" to unknown(
            source = official("Minemen Club"),
            notes = "Ladder exists publicly, but exact inventory is not exposed on the public site."
        ),

        "boxing" to unknown(
            source = official("Minemen Club"),
            notes = "Ladder exists publicly, but exact inventory is not exposed on the public site."
        ),

        "sumo" to unknown(
            source = official("Minemen Club"),
            notes = "Ladder exists publicly, but exact inventory is not exposed on the public site."
        ),

        "build-uhc" to unknown(
            source = official("Minemen Club"),
            notes = "Ladder exists publicly, but exact inventory is not exposed on the public site."
        ),

        "bridge" to unknown(
            source = official("Minemen Club"),
            notes = "Ladder exists publicly, but exact inventory is not exposed on the public site."
        ),

        "fireball-fight" to unknown(
            source = official("Minemen Club"),
            notes = "Ladder exists publicly, but exact inventory is not exposed on the public site."
        ),

        "only-sword" to partial(
            source = official("GommeHD Duels"),
            notes = "Official description confirms composition but not exact slot order or apple count.",
            items = listOf(
                loose("diamond_armor"),
                loose("golden_apple")
            )
        )
    )

    val variantLoadoutsByKey: Map<String, KitLoadout> = mapOf(
        // PvP Legacy
        "pvp-legacy:uhc-duels" to partial(
            source = community("PvP Legacy Wiki - UHC Duels"),
            notes = "Public source gives exact enchants, but not the full consumable/block counts in parsed text.",
            items = listOf(
                item("diamond_helmet", 1, "protection_3"),
                item("diamond_chestplate", 1, "protection_3"),
                item("diamond_leggings", 1, "protection_2"),
                item("diamond_boots", 1, "protection_3"),
                item("diamond_sword", 1, "sharpness_4"),
                item("diamond_axe", 1, "sharpness_1"),
                item("bow", 1, "power_1"),
                item("crossbow", 1, "piercing_1"),
                item("diamond_pickaxe", 1, "efficiency_3", "unbreaking_3")
            )
        ),

        "pvp-legacy:crystal" to partial(
            source = community("PvP Legacy Wiki - Crystal Duels"),
            notes = "Public source gives exact enchants, but not the full crystal/anchor/obsidian stack counts in parsed text.",
            items = listOf(
                item("netherite_sword", 1, "sharpness_5", "knockback_1", "mending", "unbreaking_3", "sweeping_edge_3"),
                item("crossbow", 1, "quick_charge_3", "multishot", "mending", "unbreaking_3"),
                item("netherite_pickaxe", 1, "efficiency_5", "unbreaking_3"),
                item("netherite_helmet", 1, "protection_4"),
                item("netherite_chestplate", 1, "protection_4"),
                item("netherite_leggings", 1, "protection_4", "blast_protection_4"),
                item("netherite_boots", 1, "protection_4")
            )
        ),

        "pvp-legacy:axe-shield" to partial(
            source = community("PvP Legacy Wiki - Axe Duels"),
            notes = "Mode is confirmed and explicitly has no healing items, but the parsed public page does not expose the exact item list.",
            rules = listOf(
                rule("healing_items", "none")
            )
        ),

        // GommeHD
        "gommehd:uhc-duels" to partial(
            source = official("GommeHD Duels Release"),
            notes = "Official description confirms composition only.",
            items = listOf(
                loose("enchanted_diamond_armor"),
                loose("shield"),
                loose("golden_apple"),
                loose("tools"),
                loose("blocks")
            ),
            rules = listOf(
                rule("natural_regeneration", "off")
            )
        ),

        "gommehd:crystal" to partial(
            source = official("GommeHD Duels Release"),
            notes = "Official description confirms composition only.",
            items = listOf(
                loose("enchanted_netherite_armor"),
                loose("golden_apple"),
                loose("totem_of_undying"),
                loose("ender_pearl"),
                loose("potion"),
                loose("end_crystal")
            )
        ),

        "gommehd:only-sword" to partial(
            source = official("GommeHD Duels Release"),
            notes = "Official description confirms composition only.",
            items = listOf(
                loose("diamond_armor"),
                loose("golden_apple")
            )
        ),

        "gommehd:axe-shield" to partial(
            source = official("GommeHD Duels Release"),
            notes = "Official description confirms composition only.",
            items = listOf(
                loose("diamond_armor"),
                loose("shield"),
                loose("diamond_axe"),
                loose("diamond_sword"),
                loose("bow"),
                loose("crossbow"),
                loose("arrow")
            )
        ),

        "gommehd:netherite-pot" to partial(
            source = official("GommeHD Duels Release"),
            notes = "Official description confirms composition only.",
            items = listOf(
                loose("enchanted_netherite_armor"),
                loose("potion"),
                loose("totem_of_undying"),
                loose("golden_apple")
            )
        ),

        // Minemen ladders: known to exist, exact inventories still unverified
        "minemen-club:classic" to unknown(
            source = official("Minemen Club Leaderboards"),
            notes = "Classic ladder exists publicly; exact loadout still needs manual verification."
        ),
        "minemen-club:nodebuff" to unknown(
            source = official("Minemen Club Leaderboards"),
            notes = "NoDebuff ladder exists publicly; exact loadout still needs manual verification."
        ),
        "minemen-club:boxing" to unknown(
            source = official("Minemen Club Leaderboards"),
            notes = "Boxing ladder exists publicly; exact loadout still needs manual verification."
        ),
        "minemen-club:sumo" to unknown(
            source = official("Minemen Club Leaderboards"),
            notes = "Sumo ladder exists publicly; exact loadout still needs manual verification."
        ),
        "minemen-club:build-uhc" to unknown(
            source = official("Minemen Club Leaderboards"),
            notes = "BuildUHC ladder exists publicly; exact loadout still needs manual verification."
        ),
        "minemen-club:bridge" to unknown(
            source = official("Minemen Club Leaderboards"),
            notes = "Bridges ladder exists publicly; exact loadout still needs manual verification."
        ),
        "minemen-club:fireball-fight" to unknown(
            source = official("Minemen Club Leaderboards"),
            notes = "Fireball Fight ladder exists publicly; exact loadout still needs manual verification."
        )
    )

    fun getLoadout(serverSlug: String, kitSlug: String): KitLoadout {
        return variantLoadoutsByKey["$serverSlug:$kitSlug"]
            ?: templateLoadoutsByKitSlug[kitSlug]
            ?: unknown(
                source = official("Seed fallback"),
                notes = "No seeded loadout found yet."
            )
    }

    private fun item(
        key: String,
        amount: Int,
        vararg enchants: String
    ) = KitLoadoutItem(
        itemKey = key,
        amount = amount,
        enchantments = enchants.toList(),
        exactAmount = true
    )

    private fun loose(key: String) = KitLoadoutItem(
        itemKey = key,
        amount = null,
        enchantments = emptyList(),
        exactAmount = false
    )

    private fun rule(key: String, value: String) = KitLoadoutRule(key, value)

    private fun exact(
        source: LoadoutSource,
        notes: String,
        items: List<KitLoadoutItem> = emptyList(),
        rules: List<KitLoadoutRule> = emptyList()
    ) = KitLoadout(
        precision = LoadoutPrecision.EXACT,
        items = items,
        rules = rules,
        sources = listOf(source),
        notes = notes
    )

    private fun partial(
        source: LoadoutSource,
        notes: String,
        items: List<KitLoadoutItem> = emptyList(),
        rules: List<KitLoadoutRule> = emptyList()
    ) = KitLoadout(
        precision = LoadoutPrecision.PARTIAL,
        items = items,
        rules = rules,
        sources = listOf(source),
        notes = notes
    )

    private fun flexible(
        source: LoadoutSource,
        notes: String,
        items: List<KitLoadoutItem> = emptyList(),
        rules: List<KitLoadoutRule> = emptyList()
    ) = KitLoadout(
        precision = LoadoutPrecision.FLEXIBLE,
        items = items,
        rules = rules,
        sources = listOf(source),
        notes = notes
    )

    private fun unknown(
        source: LoadoutSource,
        notes: String
    ) = KitLoadout(
        precision = LoadoutPrecision.UNKNOWN,
        items = emptyList(),
        rules = emptyList(),
        sources = listOf(source),
        notes = notes
    )

    private fun official(label: String) = LoadoutSource(
        label = label,
        reliability = SourceReliability.OFFICIAL
    )

    private fun community(label: String) = LoadoutSource(
        label = label,
        reliability = SourceReliability.COMMUNITY
    )
}