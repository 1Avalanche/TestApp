package com.example.testapp.ui.product_screen

import com.example.testapp.domain.entities.ItemTag

class TempModel {
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