package com.example.testapp.ui.product_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.ui.product_screen.components.ProductInfo
import com.example.testapp.ui.product_screen.components.SimilarRelatedItemsRow
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
                item { ProductInfo(
                    info = (state.value as ProductPageViewState.Display).productInfo,
                    showAllCharacters = (state.value as ProductPageViewState.Display).showAllCharacter,
                    viewModel = viewModel) }
                (state.value as ProductPageViewState.Display).similarProducts?. let {
                    item { SimilarRelatedItemsRow(
                        title = stringResource(id = R.string.title_similar_products),
                        itemList =it )}
                }
                (state.value as ProductPageViewState.Display).relatedProducts?. let {
                    item { SimilarRelatedItemsRow(
                        title = stringResource(id = R.string.title_related_products),
                        itemList =it )}
                }
                item { Spacer(modifier = Modifier.fillMaxWidth().height(80.dp)) }

            }
        }
    }

    LaunchedEffect(key1 = true, block = {
        viewModel.getData()
    })
}