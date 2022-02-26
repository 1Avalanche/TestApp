package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.ui.product_screen.ProductTitleWithMainInfo
import com.example.testapp.ui.theme.TestAppTheme
import com.example.testapp.utils.PhraseUtils
import kotlin.math.roundToInt

@Composable
fun ProductTitleWithCodes(title: String, vendorCode: String, barcode: String, ratio: Float, countOfReview: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 16.dp, bottom = 19.dp)) {

        VendorCodeBarcode(vendorCode, barcode)
        Text(text = title,
            style = TestAppTheme.typography.h1)
        RatioAndReviews(ratio, countOfReview)
    }
}

@Composable
fun VendorCodeBarcode(vendorCode:String, barcode: String) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)) {

        Text(text = vendorCode,
            style = TestAppTheme.typography.subtitle2,
            modifier = Modifier.padding(end = 16.dp))

        Icon(painter = painterResource(id = R.drawable.ic_barcode),
            contentDescription = "icon barcode",
            modifier = Modifier
                .padding(end = 4.dp)
                .align(Alignment.CenterVertically))

        Text(text = barcode,
            style = TestAppTheme.typography.subtitle2,
            modifier = Modifier
                .padding(end = 4.dp))

        Icon(painter = painterResource(id = R.drawable.ic_arrow_down),
            contentDescription = "icon arrow down",
            modifier = Modifier
                .padding(start = 4.dp)
                .align(Alignment.CenterVertically)
                .clickable { })
    }
}

@Composable
fun RatioAndReviews(ratio: Float, countReview: Int) {

    Row(verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.padding(top = 14.dp)) {
        RatioRow(ratio, R.drawable.ic_star, R.drawable.ic_half_star, 14)
        if (countReview >= 0) {
            Text(text = PhraseUtils.getReviewCounterSemanticString(countReview),
                style = TestAppTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductTitleWithCodes() {
    TestAppTheme {
        ProductTitleWithCodes("Заголовок", "hjksdgjhjh", "3246 26243 246", 4.5F, 231)
    }
}