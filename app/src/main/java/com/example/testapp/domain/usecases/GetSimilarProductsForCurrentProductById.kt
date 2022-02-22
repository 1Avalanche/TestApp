package com.example.testapp.domain.usecases

import com.example.testapp.domain.repositories.ProductItemRepository

class GetSimilarProductsForCurrentProductById(private val repository: ProductItemRepository) {

    suspend fun invoke(currentProductId: Int) = repository.getSimilarProducts(currentProductId)
}