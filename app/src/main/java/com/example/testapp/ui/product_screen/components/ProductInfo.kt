package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testapp.ui.product_screen.ProductPageViewModel
import com.example.testapp.ui.product_screen.model.ProductItemModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun ProductInfo(info: ProductItemModel, showAllCharacters: Boolean, viewModel: ProductPageViewModel?) {
    Column(modifier = Modifier.fillMaxWidth()) {
       ProductImagePager(imageList = info.imageList, tagsList = info.tagsList)
       ProductTitleWithCodes(info.title, info.vendorCode, info.barcode, info.ratio, info.countOfReview)
       ProductMenu(info.priceForOne, info.datePrice, info.secondPrise, info.stockCount)
       ProductCharacters(info.character, showAllCharacters, viewModel)
    }
}