package com.example.testapp.data.mappers

import com.example.testapp.R
import com.example.testapp.TestApp
import com.example.testapp.data.entities.ProductItemEntity
import com.example.testapp.data.entities.ProductWithCropInfo
import com.example.testapp.domain.entities.ItemTag
import com.example.testapp.domain.entities.ProductItem
import com.example.testapp.ui.product_screen.model.ProductItemModel

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

    fun productItemToProductWithCropInfo(product: ProductItem) : ProductWithCropInfo {
        return ProductWithCropInfo(
            id = product.id,
            title = product.title ?: TestApp().get()?.resources?.getString(R.string.unknown_title) ?: "",
            vendorCode = product.vendorCode ?: TestApp().get()?.resources?.getString(R.string.unknown_vendorcode) ?: "",
            image = product.imageList?.get(0) ?: R.drawable.item_placeholder,
            priceForOne = product.prise?.priceForOne ?: -1F,
            stockCount = product.stockCount ?: -1,
        )
    }

    fun productItemToProductWithCropInfo(products: List<ProductItem>?) : List<ProductWithCropInfo>? {
        val list : MutableList<ProductWithCropInfo> = mutableListOf()
        products?.let {
            it.forEach { product ->
                list.add(productItemToProductWithCropInfo(product))
            }
        }
        return if (list.isEmpty()) null else list
    }

    fun productItemToProductModel(product: ProductItem) : ProductItemModel {
        return ProductItemModel(
            id = product.id,
            title = product.title ?: TestApp().get()?.resources?.getString(R.string.unknown_title) ?: "",
            vendorCode = product.vendorCode ?: TestApp().get()?.resources?.getString(R.string.unknown_vendorcode) ?: "",
            barcode = product.barcode ?: TestApp().get()?.resources?.getString(R.string.unknown_barcode) ?: "",
            imageList = product.imageList ?: emptyList(),
            tagsList = makeTagsList(product.tagsList ?: emptyList()),
            ratio = product.ratio ?: -1F,
            countOfReview = product.countOfReview ?: 0,
            priceForOne = product.prise?.priceForOne ?: -1F,
            datePrice = product.prise?.datePrice ?: TestApp().get()?.resources?.getString(R.string.unknown) ?: "",
            secondPrise = product.prise?.secondPrise ?: -1F,
            stockCount = product.stockCount ?: -1,
            character = product.character ?: emptyList()
        )
    }

    private fun makeTagsList(tagsList: List<ItemTag>) : List<Pair<ItemTag?, ItemTag?>> {
        val tagsNullList = mutableListOf<ItemTag?>()
        tagsNullList.addAll(tagsList)
        var range = tagsNullList.size
        for (i in 0 until range) {
            tagsNullList[i]?.let {
                if (it.text.length >=12) {
                    tagsNullList.add(i + 1, null)
                    range++
                }
            }
        }

        val tagsPairsList = mutableListOf<Pair<ItemTag?, ItemTag?>>()
        for (i in 0 until tagsNullList.size step 2) {
            if (i < tagsNullList.lastIndex) {
                tagsPairsList.add(Pair(tagsNullList[i], tagsNullList[i+1]))
            } else {
                tagsPairsList.add(Pair(tagsNullList[i], null))
            }
        }
        return tagsPairsList
    }
}