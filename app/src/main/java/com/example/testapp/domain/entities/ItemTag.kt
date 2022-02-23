package com.example.testapp.domain.entities


data class ItemTag(
    val text: String,
    val type: TagType
)

enum class TagType {
    TOP,
    CATEGORY,
    COLOR_TYPE
}