package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.data.entities.ProductWithCropInfo
import com.example.testapp.ui.theme.TestAppTheme
import com.example.testapp.utils.PriceUtils

@Composable
fun SimilarRelatedItemsRow(title: String, itemList: List<ProductWithCropInfo>) {
    Column(modifier = Modifier.padding(top = 56.dp)) {
        Text(text = title, style = TestAppTheme.typography.h1,
             modifier = Modifier.padding(horizontal = 16.dp))
        LazyRow(modifier = Modifier.padding(top = 24.dp)) {
            itemList.forEach {
                item {SimilarRelatedItem(it.title, it.image, it.priceForOne, it.stockCount, it.vendorCode)}
            }
        }
    }
}

@Composable
fun SimilarRelatedItem(title: String, image: Int, prisePerOne: Float, storageCount: Int, vendorCode: String) {
    Column(modifier = Modifier.width(151.dp).padding(16.dp)) {
        Image(painterResource(id = image),
            contentDescription = "product photo: $title",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(119.dp))
        Text(text = vendorCode,
            style = TestAppTheme.typography.subtitle2,
            modifier = Modifier.padding(vertical = 8.dp))
        Text(text = title,
            style = TestAppTheme.typography.body,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis)
        Row(modifier = Modifier.padding(top = 8.dp, bottom = 4.dp).wrapContentHeight()) {
            Text(text = PriceUtils.makePriceString(prisePerOne),
                 style = TestAppTheme.typography.span)
            Text(text = stringResource(id = R.string.postfix_prise),
                style = TestAppTheme.typography.subtitle2,
                color = TestAppTheme.colors.mainText,
                modifier = Modifier.padding(start = 4.dp).align(alignment = Alignment.Bottom))
        }
        Row() {
            Text(text = storageCount.toString(),
                style = TestAppTheme.typography.span,
                modifier = Modifier.alignByBaseline())
            Text(text = stringResource(id = R.string.postfix_count),
                style = TestAppTheme.typography.subtitle2,
                color = TestAppTheme.colors.mainText,
                modifier = Modifier.padding(start = 4.dp).alignByBaseline())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSimilarRelatedItem() {
    TestAppTheme {
        SimilarRelatedItem("Краска для стен и потолков зеленая обычная", R.drawable.item_photo, 1762F, 36, "sghjksdfg")
    }
}