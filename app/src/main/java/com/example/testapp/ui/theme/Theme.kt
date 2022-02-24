package com.example.testapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun TestAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        mainDarkColor
    } else {
        mainLightColor
    }

    val typography = TestAppTypography(
        h1 = TextStyle(
            fontSize = 22.sp,
            color = colors.mainText,
            fontWeight = FontWeight.Medium,
        ),
        h2 = TextStyle(
            fontSize = 16.sp,
            color = colors.mainText,
            fontWeight = FontWeight.Normal,
        ),
        body = TextStyle(
            fontSize = 14.sp,
            color = colors.mainText,
            fontWeight = FontWeight.Normal,
        ),
        bodyHint = TextStyle(
            fontSize = 14.sp,
            color = colors.textMinor,
            fontWeight = FontWeight.Normal,
        ),
        tag = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
        ),
        subtitle1 = TextStyle(
            fontSize = 14.sp,
            color = colors.textSecond,
            fontWeight = FontWeight.Normal,
        ),
        subtitle2 = TextStyle(
            fontSize = 12.sp,
            color = colors.textSecond,
            fontWeight = FontWeight.Normal,
        ),
        subtitle3 = TextStyle(
            fontSize = 12.sp,
            color = colors.textMinor,
            fontWeight = FontWeight.Normal,
        ),
        accent = TextStyle(
            fontSize = 34.sp,
            color = colors.mainText
        ),
        accentHint = TextStyle(
            fontSize = 14.sp,
            color = colors.mainText,
            fontFamily = SfProDisplay,
            fontWeight = FontWeight.Bold
        ),
        onButton = TextStyle(
            fontSize = 14.sp,
            color = colors.mainText,
            fontWeight = FontWeight.Medium,
            fontFamily = SfProText
        ),
        textWidget = TextStyle(
            fontSize = 15.sp,
            color = colors.mainText,
            fontWeight = FontWeight.Normal,
            fontFamily = SfProText
        ),
        span = TextStyle(
            fontSize = 16.sp,
            color = colors.mainText,
            fontWeight = FontWeight.Medium,
        ),
    )

    CompositionLocalProvider(
        LocaleTestAppColors provides colors,
        LocaleTestAppTypography provides typography,
        content = content)
}