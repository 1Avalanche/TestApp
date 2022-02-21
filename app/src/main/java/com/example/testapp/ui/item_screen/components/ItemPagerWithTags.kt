package com.example.testapp.ui.item_screen.components

import android.icu.number.Scale
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.ui.item_screen.ItemTag
import com.example.testapp.ui.theme.TestAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

val imageList = listOf<Int>(com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo, )

@ExperimentalPagerApi
@Composable
fun ItemPagerWithTags(imageList: List<Int>, tagsList: List<Pair<ItemTag?, ItemTag?>>) {

    Box(modifier = Modifier
        .padding(start = 18.dp, top = 22.dp, end = 18.dp, bottom = 16.dp)
        .fillMaxWidth()
        .wrapContentHeight()) {

        HorizontalPager(count = imageList.size,
        modifier = Modifier.padding(start = 4.dp).size(320.dp)) { page ->
            imageList.forEach { image ->
                Image(painter = painterResource(id = image),
                    contentDescription = "item image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(320.dp),)
            }
        }

        ColorTagsBlock(tagsList)
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun ItemPagerWithTagsPreview() {
    TestAppTheme {
        ItemPagerWithTags(imageList, list)
    }
}

