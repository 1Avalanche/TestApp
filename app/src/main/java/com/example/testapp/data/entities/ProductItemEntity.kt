package com.example.testapp.data.entities

data class ProductItemEntity(
    val id: Int,
    val title: String,
    val vendorCode: String,
    val barcode: String,
    val imageList: List<Int>,
    val tagsList: List<String>,
    val ratio: Float,
    val countOfReview: Int,
    val priceForOne: Float,
    val datePrice: String,
    val secondPrise: Float,
    val stockCount: Int,
    val character: List<Pair<String, String>>)