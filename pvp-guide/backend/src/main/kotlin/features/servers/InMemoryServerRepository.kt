package com.vindev.pvpguide.features.servers

class InMemoryServerRepository(
    private val servers: List<Server>
) : ServerRepository {

    override fun getAll(active: Boolean?, region: String?): List<Server> {
        return servers.filter { server ->
            val activeMatches = active == null || server.active == active
            val regionMatches = region.isNullOrBlank() || server.region.equals(region, ignoreCase = true)
            activeMatches && regionMatches
        }
    }

    override fun getBySlug(slug: String): Server? {
        return servers.firstOrNull { it.slug.equals(slug, ignoreCase = true) }
    }
}