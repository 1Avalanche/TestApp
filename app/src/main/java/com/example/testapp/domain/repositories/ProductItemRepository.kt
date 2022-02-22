package com.example.testapp.domain.repositories

import com.example.testapp.domain.common.ResponseWrapper
import com.example.testapp.domain.entities.ProductItem
import com.example.testapp.domain.entities.ProductSupply
import com.example.testapp.domain.entities.Review

interface ProductItemRepository {
    suspend fun getProduct(id: Int) : ResponseWrapper<ProductItem?>
    suspend fun getSimilarProducts(currentProductId: Int) : ResponseWrapper<List<ProductItem>?>
    suspend fun getRelatedProducts(currentProductId: Int) : ResponseWrapper<List<ProductItem>?>
    suspend fun getAllReviewsForProduct(productId: Int) : ResponseWrapper<List<Review>?>
    suspend fun getSuppliesForProduct(productId: Int) : ResponseWrapper<List<ProductSupply>?>
}