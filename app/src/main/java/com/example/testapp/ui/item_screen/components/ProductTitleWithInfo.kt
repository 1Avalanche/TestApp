package com.example.testapp.ui.item_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.ui.item_screen.ProductTitleWithMainInfo
import kotlin.math.roundToInt

@Composable
fun ProductTitleWithInfo(productInfo: ProductTitleWithMainInfo) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 16.dp)) {

        VendorCodeBarcode(productInfo.vendorCode, productInfo.barcode)

        Text(text = productInfo.title,
        modifier = Modifier.padding(bottom = 8.dp))

        RatioAndReviews(productInfo.ratio, productInfo.countOfReview)
    }
}

@Composable
fun VendorCodeBarcode(vendorCode:String, barcode: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 2.dp, bottom = 8.dp)) {

        Text(text = vendorCode,
            modifier = Modifier.padding(end = 16.dp))

        Icon(painter = painterResource(id = R.drawable.ic_barcode),
            contentDescription = "icon barcode",
            modifier = Modifier
                .padding(end = 4.dp)
                .align(Alignment.CenterVertically))

        Text(text = barcode,
            modifier = Modifier
                .padding(end = 4.dp))

        Icon(painter = painterResource(id = R.drawable.ic_arrow_down),
            contentDescription = "icon arrow down",
            modifier = Modifier
                .padding(end = 4.dp)
                .align(Alignment.CenterVertically)
                .clickable { })
    }
}

@Composable
fun RatioAndReviews(ratio: Float, countReview: Int) {

    val intRatio = ratio.roundToInt()
    val ratioModifier = when {
        intRatio.toFloat() > ratio -> intRatio-1
        intRatio.toFloat() < ratio -> intRatio
        intRatio.toFloat() == ratio -> 0
        else -> 0
    }

    Row {
        if (intRatio.toFloat() != ratio){
            for (i in 0 until ratioModifier) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "ratio star",
                    modifier = Modifier
                        .size(14.dp)
                        .padding(end = 2.dp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_half_star),
                contentDescription = "ratio half star",
                modifier = Modifier
                    .size(14.dp)
                    .padding(end = 2.dp)
            )
        } else {
            for (i in 0 until intRatio) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "ratio star",
                    modifier = Modifier
                        .size(14.dp)
                        .padding(end = 2.dp)
                )
            }
        }
        
        Text(text = countReview.toString(),
        modifier = Modifier.padding(start = 4.dp))
    }
}