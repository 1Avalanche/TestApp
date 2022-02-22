package com.example.testapp.ui.item_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testapp.ui.item_screen.components.ItemPagerWithTags
import com.example.testapp.ui.item_screen.components.imageList
import com.example.testapp.ui.item_screen.components.list
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun ProductPage() {

    LazyColumn(Modifier.fillMaxWidth()) {
        item {ItemPagerWithTags(imageList, list)}
        item {  }
    }
}