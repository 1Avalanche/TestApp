package com.example.testapp.data.repositories

import com.example.testapp.domain.common.ResponseWrapper
import com.example.testapp.domain.entities.*

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
        tagsList = listOf(ItemTag("Гамма А",TagType.COLOR_TYPE), ItemTag("Топ - 1", TagType.TOP), ItemTag("12 - Отделочные материалы", TagType.CATEGORY)),
        ratio = 4.5F,
        countOfReview = 275,
        prise = Price(1743F, "22.02.21", 161.6F),
        stockCount = 36,
        character = listOf(Pair("Рельеф", "Структурный"), Pair("Цветовая палитра", "Оранжевый"), Pair("Покрытие", "Матовый"), Pair("Тип клея", "Флизелин"), Pair("Рельеф1", "Структурный"), Pair("Цветовая палитра1", "Оранжевый"), Pair("Покрытие1", "Матовый"), Pair("Тип клея1", "Флизелин")),
        reviewList = listOf(Review("Robert Martin", "Good product! I like this color", 5))
    )

    val secondProduct = ProductItem(
        id = 1,
        title = "Валик для водных красок белый",
        vendorCode = "ЛМ 18218850",
        barcode = "4630 075 622 652",
        imageList = listOf(com.example.testapp.R.drawable.roller, com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo), //изменить
        tagsList = listOf(ItemTag("Гамма А",TagType.COLOR_TYPE), ItemTag("Топ - 1", TagType.TOP), ItemTag("12 - Отделочные материалы", TagType.CATEGORY)),
        ratio = 4F,
        countOfReview = 200,
        prise = Price(150F, "22.02.21", 161.6F),
        stockCount = 365,
        character = listOf(Pair("Рельеф", "Структурный"), Pair("Цветовая палитра", "Оранжевый"), Pair("Покрытие", "Матовый"), Pair("Тип клея", "Флизелин")),
        reviewList = listOf(Review("Linus Torvalds", "Good product! It helps me with repairs", 5))
    )

    val similarProducts = listOf(
        firstProduct, firstProduct, firstProduct, firstProduct
    )

    val relatedProducts = listOf(secondProduct, secondProduct, secondProduct, secondProduct)
}

