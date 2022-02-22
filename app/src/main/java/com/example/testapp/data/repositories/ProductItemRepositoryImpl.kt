package com.example.testapp.data.repositories

import com.example.testapp.domain.common.ResponseWrapper
import com.example.testapp.domain.entities.ProductItem
import com.example.testapp.domain.entities.ProductSupply
import com.example.testapp.domain.entities.Review
import com.example.testapp.domain.repositories.ProductItemRepository
import javax.inject.Inject

class ProductItemRepositoryImpl @Inject constructor(
    private val localeDataSource: ProductItemLocaleDataSource,
    private val remoteDataSource: ProductItemRemoteDataSource
) : ProductItemRepository {
    override suspend fun getProduct(id: Int): ResponseWrapper<ProductItem?> {
        return remoteDataSource.getProduct(id)
    }

    override suspend fun getSimilarProducts(currentProductId: Int): ResponseWrapper<List<ProductItem>?> {
        return remoteDataSource.getSimilarProducts(currentProductId)
    }

    override suspend fun getRelatedProducts(currentProductId: Int): ResponseWrapper<List<ProductItem>?> {
        return remoteDataSource.getRelatedProducts(currentProductId)
    }

    override suspend fun getAllReviewsForProduct(productId: Int): ResponseWrapper<List<Review>?> {
        return ResponseWrapper.Success(null)
    }

    override suspend fun getSuppliesForProduct(productId: Int): ResponseWrapper<List<ProductSupply>?> {
        return ResponseWrapper.Success(null)
    }
}