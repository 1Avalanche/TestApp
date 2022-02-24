package com.example.testapp.ui.product_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.testapp.ui.product_screen.components.imageList
import com.example.testapp.ui.product_screen.components.list
import com.example.testapp.ui.product_screen.model.ProductPageEvent
import com.example.testapp.ui.product_screen.model.ProductPageViewState
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@Composable
fun ProductPage(viewModel: ProductPageViewModel) {

    val state = viewModel.pageState.observeAsState()

    when (state.value) {
        ProductPageViewState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
            }
        }
        ProductPageViewState.Error -> viewModel.obtainEvent(ProductPageEvent.RefreshData)
        is ProductPageViewState.Display -> {
            LazyColumn(Modifier.fillMaxWidth()) {
                item { }
                item { }
            }
        }
    }

    LaunchedEffect(key1 = true, block = {
        viewModel.getData()
    })
}