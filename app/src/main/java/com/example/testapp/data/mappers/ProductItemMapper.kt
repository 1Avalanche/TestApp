package com.example.testapp.data.mappers

import com.example.testapp.R
import com.example.testapp.TestApp
import com.example.testapp.data.entities.ProductItemEntity
import com.example.testapp.data.entities.RelatedProductEntity
import com.example.testapp.data.entities.SimilarProductEntity
import com.example.testapp.domain.entities.ProductItem

object ProductItemMapper {

    fun productItemToProductItemEntity(product: ProductItem) : ProductItemEntity {

        return ProductItemEntity(
            id = product.id,
            title = product.title ?: TestApp().get()?.resources?.getString(R.string.unknown_title) ?: "",
            vendorCode = product.vendorCode ?: TestApp().get()?.resources?.getString(R.string.unknown_vendorcode) ?: "",
            barcode = product.barcode ?: TestApp().get()?.resources?.getString(R.string.unknown_barcode) ?: "",
            imageList = product.imageList ?: emptyList(),
            tagsList = product.tagsList ?: emptyList(),
            ratio = product.ratio ?: -1F,
            countOfReview = product.countOfReview ?: 0,
            priceForOne = product.prise?.priceForOne ?: -1F,
            datePrice = product.prise?.datePrice ?: TestApp().get()?.resources?.getString(R.string.unknown) ?: "",
            secondPrise = product.prise?.secondPrise ?: -1F,
            stockCount = product.stockCount ?: -1,
            character = product.character ?: emptyList()
        )
    }

    fun productItemToSimilarProductEntity(product: ProductItem) : SimilarProductEntity {
        return SimilarProductEntity(
            id = product.id,
            title = product.title ?: TestApp().get()?.resources?.getString(R.string.unknown_title) ?: "",
            vendorCode = product.vendorCode ?: TestApp().get()?.resources?.getString(R.string.unknown_vendorcode) ?: "",
            image = product.imageList?.get(0) ?: R.drawable.item_placeholder,
            priceForOne = product.prise?.priceForOne ?: -1F,
            stockCount = product.stockCount ?: -1,
        )
    }

    fun productItemToRelatedProduct(product: ProductItem) : RelatedProductEntity {
        return RelatedProductEntity(
            id = product.id,
            title = product.title ?: TestApp().get()?.resources?.getString(R.string.unknown_title) ?: "",
            vendorCode = product.vendorCode ?: TestApp().get()?.resources?.getString(R.string.unknown_vendorcode) ?: "",
            image = product.imageList?.get(0) ?: com.example.testapp.R.drawable.item_placeholder,
            priceForOne = product.prise?.priceForOne ?: -1F,
            stockCount = product.stockCount ?: -1,
        )
    }
}