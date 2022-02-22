package com.example.testapp.data.repositories

import com.example.testapp.domain.common.ResponseWrapper
import com.example.testapp.domain.entities.Price
import com.example.testapp.domain.entities.ProductItem
import com.example.testapp.domain.entities.Review

class ProductItemRemoteDataSourceImpl : ProductItemRemoteDataSource {
    override suspend fun getProduct(id: Int): ResponseWrapper<ProductItem?> {
        return ResponseWrapper.Success(MockData.firstProduct)
    }

    override suspend fun getSimilarProducts(currentProductId: Int): ResponseWrapper<List<ProductItem>?> {
        return ResponseWrapper.Success(MockData.similarProducts)
    }

    override suspend fun getRelatedProducts(currentProductId: Int): ResponseWrapper<List<ProductItem>?> {
        return ResponseWrapper.Success(MockData.relatedProducts)
    }

}

object MockData {
    val firstProduct = ProductItem(
        id = 1,
        title = "Краска для стен и потолков Trend Farbe цвет Сочный апельсин 1 л",
        vendorCode = "ЛМ 18218850",
        barcode = "4630 075 622 652",
        imageList = listOf(com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo),
        tagsList = listOf("Гамма А", "Топ - 1", "12 - Отделочные материалы"),
        ratio = 4.5F,
        countOfReview = 275,
        prise = Price(1743F, "22.02.21", 161.6F),
        stockCount = 36,
        character = listOf(Pair("Рельеф", "Структурный"), Pair("Цветовая палитра", "Оранжевый"), Pair("Покрытие", "Матовый"), Pair("Тип клея", "Флизелин")),
        reviewList = listOf(Review("Bob Martin", "Good product! I like this color", 5))
    )

    val secondProduct = ProductItem(
        id = 1,
        title = "Валик для водных красок",
        vendorCode = "ЛМ 18218850",
        barcode = "4630 075 622 652",
        imageList = listOf(com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo), //изменить
        tagsList = listOf("Гамма А", "Топ - 1", "12 - Отделочные материалы"),
        ratio = 4F,
        countOfReview = 200,
        prise = Price(150F, "22.02.21", 161.6F),
        stockCount = 365,
        character = listOf(Pair("Рельеф", "Структурный"), Pair("Цветовая палитра", "Оранжевый"), Pair("Покрытие", "Матовый"), Pair("Тип клея", "Флизелин")),
        reviewList = listOf(Review("Linus Torvalds", "Good product! It helps me with repairs", 5))
    )

    val similarProducts = listOf(
        firstProduct, firstProduct, firstProduct, secondProduct
    )

    val relatedProducts = listOf(secondProduct, secondProduct, secondProduct, secondProduct)
}

