package com.example.testapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class TestAppColors(
    val mainBackground: Color,
    val mainText: Color,
    val iconTint: Color,
    val textSecond: Color,
    val textMinor: Color,
    val button: Color,
    val tagTop: Color,
    val tagTopText: Color,
    val tagCategory: Color,
    val tagColor: Color
)

object TestAppTheme {
    val colors: TestAppColors
    @Composable
    get() = LocaleTestAppColors.current
}

val LocaleTestAppColors = staticCompositionLocalOf<TestAppColors> {
    error("error get colors")
}

