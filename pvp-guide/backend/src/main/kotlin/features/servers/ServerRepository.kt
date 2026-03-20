package com.vindev.pvpguide.features.servers

interface ServerRepository {
    fun getAll(active: Boolean? = null, region: String? = null): List<Server>
    fun getBySlug(slug: String): Server?
}