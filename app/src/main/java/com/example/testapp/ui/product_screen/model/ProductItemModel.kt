package com.example.testapp.ui.product_screen.model

import com.example.testapp.domain.entities.ItemTag

data class ProductItemModel(
    val id: Int,
    val title: String,
    val vendorCode: String,
    val barcode: String,
    val imageList: List<Int>,
    val tagsList: List<Pair<ItemTag?, ItemTag?>>,
    val ratio: Float,
    val countOfReview: Int,
    val priceForOne: Float,
    val datePrice: String,
    val secondPrise: Float,
    val stockCount: Int,
    val character: List<Pair<String, String>>)