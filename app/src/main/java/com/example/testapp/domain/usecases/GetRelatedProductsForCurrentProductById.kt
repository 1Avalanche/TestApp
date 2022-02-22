package com.example.testapp.domain.usecases

import com.example.testapp.domain.repositories.ProductItemRepository
import javax.inject.Inject

class GetRelatedProductsForCurrentProductById @Inject constructor(private val repository: ProductItemRepository) {

    suspend fun invoke(currentProductId: Int) = repository.getRelatedProducts(currentProductId)
}