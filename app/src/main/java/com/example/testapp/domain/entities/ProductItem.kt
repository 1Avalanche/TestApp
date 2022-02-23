package com.example.testapp.domain.entities

data class ProductItem(
    val id: Int,
    val title: String?,
    val vendorCode: String?,
    val barcode: String?,
    val imageList: List<Int>?,
    val tagsList: List<ItemTag>?,
    val ratio: Float?,
    val countOfReview: Int?,
    val prise: Price?,
    val stockCount: Int?,
    val character: List<Pair<String, String>>?,
    val reviewList: List<Review>?
)
