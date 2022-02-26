package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.domain.entities.ItemTag
import com.example.testapp.ui.theme.TestAppTheme
import com.google.accompanist.pager.*

val imageList = listOf<Int>(com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo, com.example.testapp.R.drawable.item_photo, )

@ExperimentalPagerApi
@Composable
fun ProductImagePager(imageList: List<Int>, tagsList: List<Pair<ItemTag?, ItemTag?>>) {

    Box(modifier = Modifier
        .padding(start = 18.dp, top = 22.dp, end = 18.dp, bottom = 16.dp)
        .fillMaxWidth()
        .wrapContentHeight()) {

        val pagerState = rememberPagerState()
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            HorizontalPager(count = imageList.size,
                state = pagerState,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(320.dp)) { page ->
                imageList.forEach { image ->
                    Image(painter = painterResource(id = image),
                        contentDescription = "item image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(320.dp),)
                }

            }
           HorizontalPagerIndicator(pagerState = pagerState,
               activeColor = TestAppTheme.colors.mainText.copy(alpha = 0.7f),
               inactiveColor = TestAppTheme.colors.mainText.copy(alpha = 0.3f),
               indicatorWidth = 6.dp, indicatorHeight = 6.dp,
               modifier = Modifier.padding(top = 10.dp)
           )
        }

        ColorTagsBlock(tagsList)
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun ItemPagerWithTagsPreview() {
    TestAppTheme {
        ProductImagePager(imageList, list)
    }
}

