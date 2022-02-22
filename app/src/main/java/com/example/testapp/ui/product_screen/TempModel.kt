package com.example.testapp.ui.product_screen

class TempModel {
}

data class ItemTag(
    val text: String,
    val type: TagType
)

enum class TagType {
    TOP,
    CATEGORY,
    COLOR_TYPE
}

data class ProductTitleWithMainInfo(
    val imageList: List<Int>,
    val tagsList: List<Pair<ItemTag?, ItemTag?>>,
    val title: String,
    val vendorCode: String,
    val barcode: String,
    val countOfReview: Int,
    val ratio: Float
)