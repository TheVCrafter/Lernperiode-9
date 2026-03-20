package com.vindev.pvpguide.plugins

import com.vindev.pvpguide.data.SeedData
import com.vindev.pvpguide.features.drills.InMemoryDrillRepository
import com.vindev.pvpguide.features.drills.registerDrillRoutes
import com.vindev.pvpguide.features.health.registerHealthRoutes
import com.vindev.pvpguide.features.kits.InMemoryKitRepository
import com.vindev.pvpguide.features.kits.registerKitRoutes
import com.vindev.pvpguide.features.kitvariants.InMemoryKitVariantRepository
import com.vindev.pvpguide.features.kitvariants.registerKitVariantRoutes
import com.vindev.pvpguide.features.mechanics.InMemoryMechanicRepository
import com.vindev.pvpguide.features.mechanics.registerMechanicRoutes
import com.vindev.pvpguide.features.servers.InMemoryServerRepository
import com.vindev.pvpguide.features.servers.registerServerRoutes
import com.vindev.pvpguide.features.techniques.InMemoryTechniqueRepository
import com.vindev.pvpguide.features.techniques.registerTechniqueRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val serverRepository = InMemoryServerRepository(SeedData.servers)
    val kitRepository = InMemoryKitRepository(SeedData.kits)
    val kitVariantRepository = InMemoryKitVariantRepository(
        kitVariants = SeedData.kitVariants,
        loadouts = emptyMap() // keep your current SeedLoadouts integration if you already added it
    )

    val mechanicRepository = InMemoryMechanicRepository(SeedData.mechanics)
    val techniqueRepository = InMemoryTechniqueRepository(SeedData.techniques)
    val drillRepository = InMemoryDrillRepository(SeedData.drills)

    routing {
        route("/api") {
            registerHealthRoutes()
            registerServerRoutes(serverRepository, kitVariantRepository)
            registerKitRoutes(kitRepository, kitVariantRepository)
            registerKitVariantRoutes(kitVariantRepository)

            registerMechanicRoutes(mechanicRepository, techniqueRepository)
            registerTechniqueRoutes(techniqueRepository)
            registerDrillRoutes(drillRepository)
        }
    }
}