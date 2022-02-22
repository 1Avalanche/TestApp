package com.example.testapp.ui.product_screen.model

import com.example.testapp.data.entities.ProductItemEntity
import com.example.testapp.data.entities.RelatedProductEntity
import com.example.testapp.data.entities.SimilarProductEntity
import com.example.testapp.domain.entities.ProductItem

sealed class ProductPageViewState {
    object Loading : ProductPageViewState()
    object Error : ProductPageViewState()
    data class Display(
        val productInfo: ProductItemEntity,
        val similarProducts: List<SimilarProductEntity>?,
        val relatedProducts: List<RelatedProductEntity>?
    ) : ProductPageViewState()
}