package com.vindev.pvpguide.features.tags

import com.vindev.pvpguide.common.model.TagType

class InMemoryTagRepository(
    private val tags: List<Tag>
) : TagRepository {

    override fun getAll(type: TagType?): List<Tag> {
        return tags.filter { tag ->
            type == null || tag.type == type
        }
    }

    override fun getById(id: Long): Tag? {
        return tags.firstOrNull { it.id == id }
    }

    override fun getBySlug(slug: String): Tag? {
        return tags.firstOrNull { it.slug.equals(slug, ignoreCase = true) }
    }
}