package com.example.testapp.domain.usecases

import com.example.testapp.domain.repositories.ProductItemRepository

class GetRelatedProductsForCurrentProductById(private val repository: ProductItemRepository) {

    suspend fun invoke(currentProductId: Int) = repository.getRelatedProducts(currentProductId)
}