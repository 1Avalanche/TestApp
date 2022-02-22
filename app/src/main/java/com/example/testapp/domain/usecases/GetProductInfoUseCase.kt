package com.example.testapp.domain.usecases

import com.example.testapp.domain.repositories.ProductItemRepository

class GetProductInfoUseCase(private val repository: ProductItemRepository) {

    suspend fun invoke(productId: Int) = repository.getProduct(productId)
}