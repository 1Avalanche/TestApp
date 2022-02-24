package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.TestApp
import com.example.testapp.ui.theme.TestAppTheme
import com.example.testapp.utils.PhraseUtils

@Composable
fun Reviews(ratio: Float, countOfReviews: Int) {
    Column(modifier = Modifier.padding(top = 56.dp, start = 16.dp, end = 16.dp)) {
        Text(text = stringResource(id = R.string.title_reviews), style = TestAppTheme.typography.h1)
        Column(modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(text = ratio.toString().replace(".", ","),
                style = TestAppTheme.typography.accent)

                Row(modifier = Modifier.padding(8.dp)) {
                    RatioRow(ratio, R.drawable.black_star, R.drawable.black_star_half, 16)
                }
            }
            Text(text = PhraseUtils.getSemanticTextBasedReview(countOfReviews),
                style = TestAppTheme.typography.textWidget,
                modifier = Modifier.padding(top = 7.dp))
        }
        LinkButton(stringResource(id = R.string.button_show_all), { })
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewReviews() {
    TestAppTheme {
        Reviews(3.6F, 271)
    }
}

