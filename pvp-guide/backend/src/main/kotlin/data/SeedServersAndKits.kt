package com.vindev.pvpguide.data

import com.vindev.pvpguide.common.model.VersionGroup
import com.vindev.pvpguide.features.kits.Kit
import com.vindev.pvpguide.features.kitvariants.KitRuleFlags
import com.vindev.pvpguide.features.kitvariants.KitVariant
import com.vindev.pvpguide.features.servers.Server

object SeedServersAndKits {

    val servers = listOf(
        Server(
            id = 1,
            slug = "minemen-club",
            name = "Minemen Club",
            region = "GLOBAL",
            active = true,
            supportedVersionGroups = listOf(VersionGroup.V1_8_PLUS)
        ),
        Server(
            id = 2,
            slug = "pvp-legacy",
            name = "PvP Legacy",
            region = "GLOBAL",
            active = true,
            supportedVersionGroups = listOf(VersionGroup.V1_9_PLUS)
        ),
        Server(
            id = 3,
            slug = "hypixel",
            name = "Hypixel",
            region = "GLOBAL",
            active = true,
            supportedVersionGroups = listOf(VersionGroup.V1_8_PLUS)
        ),
        Server(
            id = 4,
            slug = "hoplite",
            name = "Hoplite",
            region = "GLOBAL",
            active = true,
            supportedVersionGroups = listOf(VersionGroup.V1_9_PLUS)
        ),
        Server(
            id = 5,
            slug = "gommehd",
            name = "GommeHD",
            region = "GLOBAL",
            active = true,
            supportedVersionGroups = listOf(
                VersionGroup.V1_8_PLUS,
                VersionGroup.V1_9_PLUS
            )
        ),
        Server(
            id = 6,
            slug = "pvp-club",
            name = "PvP Club",
            region = "GLOBAL",
            active = true,
            supportedVersionGroups = listOf(VersionGroup.V1_9_PLUS)
        )
    )

    val kits = listOf(
        Kit(
            id = 1,
            slug = "classic",
            name = "Classic",
            description = "Traditional rod-and-sword practice kit.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 2,
            slug = "nodebuff",
            name = "NoDebuff",
            description = "Potion PvP with sustain and inventory management.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 3,
            slug = "boxing",
            name = "Boxing",
            description = "Movement and hit trading without weapon complexity.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 4,
            slug = "sumo",
            name = "Sumo",
            description = "Knockback and positioning focused PvP.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 5,
            slug = "build-uhc",
            name = "BuildUHC",
            description = "1.8 UHC-style duel format with utility and blocks.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 6,
            slug = "bridge",
            name = "Bridge",
            description = "Movement and pressure focused objective PvP.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 7,
            slug = "fireball-fight",
            name = "Fireball Fight",
            description = "Explosive movement and spacing practice.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 8,
            slug = "sword",
            name = "Sword",
            description = "Modern sword-focused melee.",
            versionGroup = VersionGroup.V1_9_PLUS
        ),
        Kit(
            id = 9,
            slug = "crystal",
            name = "Crystal",
            description = "End crystal PvP focused on burst damage and placement.",
            versionGroup = VersionGroup.V1_9_PLUS
        ),
        Kit(
            id = 10,
            slug = "axe-shield",
            name = "Axe & Shield",
            description = "Modern shield timing and axe pressure.",
            versionGroup = VersionGroup.V1_9_PLUS
        ),
        Kit(
            id = 11,
            slug = "uhc-duels",
            name = "UHC Duels",
            description = "Modern UHC-style duels with utility and ranged pressure.",
            versionGroup = VersionGroup.V1_9_PLUS
        ),
        Kit(
            id = 12,
            slug = "netherite-pot",
            name = "Netherite Pot",
            description = "Potion-heavy modern duel format with netherite gear.",
            versionGroup = VersionGroup.V1_9_PLUS
        ),
        Kit(
            id = 13,
            slug = "pot",
            name = "Pot",
            description = "Classic potion PvP template.",
            versionGroup = VersionGroup.V1_8_PLUS
        ),
        Kit(
            id = 14,
            slug = "only-sword",
            name = "Only Sword",
            description = "Simple melee format with minimal utility.",
            versionGroup = VersionGroup.V1_9_PLUS
        ),
        Kit(
            id = 15,
            slug = "mace",
            name = "Mace",
            description = "Modern vertical burst and timing focused PvP.",
            versionGroup = VersionGroup.V1_9_PLUS
        )
    )

    val kitVariants = listOf(
        // Minemen Club
        KitVariant(
            id = 101,
            kitId = 1,
            serverId = 1,
            kitSlug = "classic",
            serverSlug = "minemen-club",
            displayName = "Minemen Classic",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = standard1_8Rules()
        ),
        KitVariant(
            id = 102,
            kitId = 2,
            serverId = 1,
            kitSlug = "nodebuff",
            serverSlug = "minemen-club",
            displayName = "Minemen NoDebuff",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = nodebuffRules()
        ),
        KitVariant(
            id = 103,
            kitId = 3,
            serverId = 1,
            kitSlug = "boxing",
            serverSlug = "minemen-club",
            displayName = "Minemen Boxing",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = standard1_8Rules()
        ),
        KitVariant(
            id = 104,
            kitId = 4,
            serverId = 1,
            kitSlug = "sumo",
            serverSlug = "minemen-club",
            displayName = "Minemen Sumo",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = standard1_8Rules()
        ),
        KitVariant(
            id = 105,
            kitId = 5,
            serverId = 1,
            kitSlug = "build-uhc",
            serverSlug = "minemen-club",
            displayName = "Minemen BuildUHC",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = buildUhcRules()
        ),
        KitVariant(
            id = 106,
            kitId = 6,
            serverId = 1,
            kitSlug = "bridge",
            serverSlug = "minemen-club",
            displayName = "Minemen Bridge",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = bridgeRules()
        ),
        KitVariant(
            id = 107,
            kitId = 7,
            serverId = 1,
            kitSlug = "fireball-fight",
            serverSlug = "minemen-club",
            displayName = "Minemen Fireball Fight",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = bridgeRules()
        ),

        // PvP Legacy
        KitVariant(
            id = 201,
            kitId = 8,
            serverId = 2,
            kitSlug = "sword",
            serverSlug = "pvp-legacy",
            displayName = "Legacy Sword",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = swordRules()
        ),
        KitVariant(
            id = 202,
            kitId = 9,
            serverId = 2,
            kitSlug = "crystal",
            serverSlug = "pvp-legacy",
            displayName = "Legacy Crystal",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = crystalRules()
        ),
        KitVariant(
            id = 203,
            kitId = 10,
            serverId = 2,
            kitSlug = "axe-shield",
            serverSlug = "pvp-legacy",
            displayName = "Legacy Axe & Shield",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = axeShieldRules()
        ),
        KitVariant(
            id = 204,
            kitId = 11,
            serverId = 2,
            kitSlug = "uhc-duels",
            serverSlug = "pvp-legacy",
            displayName = "Legacy UHC Duels",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = uhcRules()
        ),

        // GommeHD
        KitVariant(
            id = 301,
            kitId = 9,
            serverId = 5,
            kitSlug = "crystal",
            serverSlug = "gommehd",
            displayName = "Gomme Crystal PvP",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = crystalRules()
        ),
        KitVariant(
            id = 302,
            kitId = 14,
            serverId = 5,
            kitSlug = "only-sword",
            serverSlug = "gommehd",
            displayName = "Gomme Only Sword",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = swordRules()
        ),
        KitVariant(
            id = 303,
            kitId = 10,
            serverId = 5,
            kitSlug = "axe-shield",
            serverSlug = "gommehd",
            displayName = "Gomme Axe",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = axeShieldRules()
        ),
        KitVariant(
            id = 304,
            kitId = 12,
            serverId = 5,
            kitSlug = "netherite-pot",
            serverSlug = "gommehd",
            displayName = "Gomme Netherite Pot",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = netheritePotRules()
        ),
        KitVariant(
            id = 305,
            kitId = 15,
            serverId = 5,
            kitSlug = "mace",
            serverSlug = "gommehd",
            displayName = "Gomme Mace",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = maceRules()
        ),
        KitVariant(
            id = 306,
            kitId = 11,
            serverId = 5,
            kitSlug = "uhc-duels",
            serverSlug = "gommehd",
            displayName = "Gomme UHC",
            versionGroup = VersionGroup.V1_8_PLUS,
            ranked = true,
            rules = buildUhcRules()
        ),

        // PvP Club
        KitVariant(
            id = 401,
            kitId = 8,
            serverId = 6,
            kitSlug = "sword",
            serverSlug = "pvp-club",
            displayName = "PvP Club Sword",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = swordRules()
        ),
        KitVariant(
            id = 402,
            kitId = 9,
            serverId = 6,
            kitSlug = "crystal",
            serverSlug = "pvp-club",
            displayName = "PvP Club Crystal",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = crystalRules()
        ),
        KitVariant(
            id = 403,
            kitId = 10,
            serverId = 6,
            kitSlug = "axe-shield",
            serverSlug = "pvp-club",
            displayName = "PvP Club Axe & Shield",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = axeShieldRules()
        ),
        KitVariant(
            id = 404,
            kitId = 11,
            serverId = 6,
            kitSlug = "uhc-duels",
            serverSlug = "pvp-club",
            displayName = "PvP Club UHC Duels",
            versionGroup = VersionGroup.V1_9_PLUS,
            ranked = true,
            rules = uhcRules()
        )
    )

    private fun standard1_8Rules() = KitRuleFlags(
        healingAllowed = false,
        crystalsAllowed = false,
        shieldsAllowed = false,
        lavaAllowed = false,
        bowsAllowed = false
    )

    private fun nodebuffRules() = KitRuleFlags(
        healingAllowed = true,
        crystalsAllowed = false,
        shieldsAllowed = false,
        lavaAllowed = false,
        bowsAllowed = false
    )

    private fun buildUhcRules() = KitRuleFlags(
        healingAllowed = true,
        crystalsAllowed = false,
        shieldsAllowed = false,
        lavaAllowed = true,
        bowsAllowed = true
    )

    private fun bridgeRules() = KitRuleFlags(
        healingAllowed = false,
        crystalsAllowed = false,
        shieldsAllowed = false,
        lavaAllowed = false,
        bowsAllowed = false
    )

    private fun swordRules() = KitRuleFlags(
        healingAllowed = false,
        crystalsAllowed = false,
        shieldsAllowed = true,
        lavaAllowed = false,
        bowsAllowed = false
    )

    private fun crystalRules() = KitRuleFlags(
        healingAllowed = true,
        crystalsAllowed = true,
        shieldsAllowed = true,
        lavaAllowed = true,
        bowsAllowed = false
    )

    private fun axeShieldRules() = KitRuleFlags(
        healingAllowed = false,
        crystalsAllowed = false,
        shieldsAllowed = true,
        lavaAllowed = false,
        bowsAllowed = true
    )

    private fun uhcRules() = KitRuleFlags(
        healingAllowed = true,
        crystalsAllowed = false,
        shieldsAllowed = true,
        lavaAllowed = true,
        bowsAllowed = true
    )

    private fun netheritePotRules() = KitRuleFlags(
        healingAllowed = true,
        crystalsAllowed = false,
        shieldsAllowed = true,
        lavaAllowed = false,
        bowsAllowed = false
    )

    private fun maceRules() = KitRuleFlags(
        healingAllowed = false,
        crystalsAllowed = false,
        shieldsAllowed = true,
        lavaAllowed = false,
        bowsAllowed = false
    )
}