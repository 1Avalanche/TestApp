package com.example.testapp.ui.product_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testapp.ui.product_screen.components.ItemPagerWithTags
import com.example.testapp.ui.product_screen.components.imageList
import com.example.testapp.ui.product_screen.components.list
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun ProductPage(viewModel: ProductPageViewModel) {

    LazyColumn(Modifier.fillMaxWidth()) {
        item {ItemPagerWithTags(imageList, list)}
        item {  }
    }
}