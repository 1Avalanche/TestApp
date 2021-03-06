package com.example.testapp.data.entities

data class ProductWithCropInfo(
    val id: Int,
    val title: String,
    val vendorCode: String,
    val image: Int,
    val priceForOne: Float,
    val stockCount: Int
)