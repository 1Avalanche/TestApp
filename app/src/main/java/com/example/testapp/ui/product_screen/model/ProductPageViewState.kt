package com.example.testapp.ui.product_screen.model

import com.example.testapp.data.entities.ProductWithCropInfo

sealed class ProductPageViewState {
    object Loading : ProductPageViewState()
    object Error : ProductPageViewState()
    data class Display(
        val productInfo: ProductItemModel,
        val similarProducts: List<ProductWithCropInfo>?,
        val relatedProducts: List<ProductWithCropInfo>?,
        var showAllCharacter: Boolean,
    ) : ProductPageViewState()
}