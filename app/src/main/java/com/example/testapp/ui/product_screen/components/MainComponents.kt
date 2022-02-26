package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.ui.theme.TestAppTheme
import kotlin.math.roundToInt

@Composable
fun SpacerLine() {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(TestAppTheme.colors.backgroundMinor))
}

@Composable
fun LinkButton(text: String, onClickFun: () -> Unit) {
    Button(
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(TestAppTheme.colors.button, TestAppTheme.colors.mainText),
        modifier = Modifier
            .wrapContentSize()
            .padding(top = 12.dp),
                onClick = { onClickFun }) {
            Text(text = text, style = TestAppTheme.typography.onButton)

    }
}

@Composable
fun RatioRow(ratio: Float, iconFull: Int, iconHalf: Int, iconSize: Int) {

    val ratioPair = when (ratio) {
        in 0f..0.5f -> Pair(0, true)
        in 0.5f..1f -> Pair(1, false)
        in 1f..1.5f -> Pair(1, true)
        in 1.5F..2f -> Pair(2, false)
        in 2.5F..3f -> Pair(2, true)
        in 3F..3.5f -> Pair(3, false)
        in 3.5F..4f -> Pair(3, true)
        in 3.5F..4f -> Pair(4, false)
        in 4F..4.5f -> Pair(4, true)
        in 4.5F..5f -> Pair(5, false)
        else -> Pair(5, false)
    }

    Row() {
        for (i in 0 until ratioPair.first) {
            Image(
                painter = painterResource(id = iconFull),
                contentDescription = "ratio star",
                modifier = Modifier
                    .size(iconSize.dp)
                    .padding(end = 2.dp)
            )
        }
        if (ratioPair.second) {
            Image(
                painter = painterResource(id = iconHalf),
                contentDescription = "ratio star",
                modifier = Modifier
                    .size(iconSize.dp)
                    .padding(end = 2.dp)
            )
        }
    }
}