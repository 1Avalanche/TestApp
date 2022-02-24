package com.example.testapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import org.w3c.dom.Text
import androidx.compose.ui.text.TextStyle

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
    val tagColor: Color,
    val backgroundMinor: Color
)

data class TestAppTypography (
    val h1: TextStyle,
    val h2: TextStyle,
    val body: TextStyle,
    val bodyHint: TextStyle,
    val tag: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val subtitle3: TextStyle,
    val accent: TextStyle,
    val accentHint: TextStyle,
    val onButton: TextStyle,
    val textWidget: TextStyle,
    val span: TextStyle
)

object TestAppTheme {
    val colors: TestAppColors
    @Composable
    get() = LocaleTestAppColors.current

    val typography: TestAppTypography
    @Composable
    get() = LocaleTestAppTypography.current
}

val LocaleTestAppColors = staticCompositionLocalOf<TestAppColors> {
    error("error get colors")
}

val LocaleTestAppTypography = staticCompositionLocalOf<TestAppTypography> {
    error("error get colors")
}

