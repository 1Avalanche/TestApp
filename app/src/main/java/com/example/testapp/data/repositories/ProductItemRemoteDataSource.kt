package com.example.testapp.data.repositories

import com.example.testapp.domain.common.ResponseWrapper
import com.example.testapp.domain.entities.ProductItem

interface ProductItemRemoteDataSource {
    suspend fun getProduct(id: Int) : ResponseWrapper<ProductItem?>
    suspend fun getSimilarProducts(currentProductId: Int) : ResponseWrapper<List<ProductItem>?>
    suspend fun getRelatedProducts(currentProductId: Int) : ResponseWrapper<List<ProductItem>?>
}