package com.example.testapp.domain.usecases

import com.example.testapp.domain.repositories.ProductItemRepository
import javax.inject.Inject

class GetProductInfoUseCase @Inject constructor(private val repository: ProductItemRepository) {

    suspend fun invoke(productId: Int) = repository.getProduct(productId)
}