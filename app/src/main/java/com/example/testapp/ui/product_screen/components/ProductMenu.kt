package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.ui.theme.TestAppTheme
import com.example.testapp.R

@Composable
fun ProductMenu(pricePerOne: Float, priceDate: String, secondPrice: Float, storageCount: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)){
        ProductMenuPoint(
            R.drawable.ic_menu_price, 
            stringResource(id = R.string.menu_title_prise), 
            stringResource(id = R.string.menu_prise_value, pricePerOne.toString()),
            stringResource(id = R.string.menu_subtitle_prise, priceDate),
            stringResource(id = R.string.menu_prise_subvalue, secondPrice.toString()),
        )
        SpacerLine()
        ProductMenuPoint(
            R.drawable.ic_menu_storage,
            stringResource(id = R.string.menu_title_storage),
            stringResource(id = R.string.menu_storage_value, storageCount.toString()),
            stringResource(id = R.string.menu_subtitle_storage),
            null
        )
        SpacerLine()
        ProductMenuPoint(
            R.drawable.ic_menu_supplies,
            stringResource(id = R.string.menu_title_supplies),
            null,
            stringResource(id = R.string.menu_subtitle_supplies),
            null
        )
        SpacerLine()
        ProductMenuPoint(
            R.drawable.ic_menu_history,
            stringResource(id = R.string.menu_title_sale_history),
            null,
            stringResource(id = R.string.menu_subtitle_sale_history),
            null
        )
    }
}

@Composable
fun ProductMenuPoint(iconId: Int, itemText: String,  itemValue: String?, subtext: String, subvalue: String?) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, bottom = 12.dp)) {
        Row() {
            Image(painter = painterResource(id = iconId),
                contentDescription = "icon $itemText",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(start = 2.dp, top = 4.dp)
                    .size(20.dp))
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = itemText, style = TestAppTheme.typography.h2)
                Text(text = subtext, style = TestAppTheme.typography.subtitle3)

            }
        }

        Row(horizontalArrangement = Arrangement.End) {
            Column(horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = 14.dp)) {
                itemValue?.let { Text(text = it, style = TestAppTheme.typography.h2) }
                subvalue?.let { Text(text = it, style = TestAppTheme.typography.subtitle3) }
            }
            Image(painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = "show more",
                modifier = Modifier.align(alignment = Alignment.Top))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductMenu() {
    TestAppTheme() {
        ProductMenu(1456f,"20.02.2000", 145f, 45)
    }
}