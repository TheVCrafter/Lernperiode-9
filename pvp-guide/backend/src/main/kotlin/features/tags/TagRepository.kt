package com.vindev.pvpguide.features.tags

import com.vindev.pvpguide.common.model.TagType

interface TagRepository {
    fun getAll(type: TagType? = null): List<Tag>
    fun getById(id: Long): Tag?
    fun getBySlug(slug: String): Tag?
}