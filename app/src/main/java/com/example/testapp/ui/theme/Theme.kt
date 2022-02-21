package com.example.testapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Purple700,
    secondary = Teal200,
    onPrimary = Color.Black
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

val mainLightColor = TestAppColors(
mainBackground = Color.White,
mainText = Color(0xFF333333),
iconTint = Color(0xFF464C5C),
textSecond = Color(0xFF666666),
textMinor = Color(0xFF999999),
button = Color(0xFFE8E9EB),
tagTop = Color(0xFFD1DEFF),
tagTopText = Color(0xFF3D6BE3),
tagCategory= Color(0xFFFCF2DD),
tagColor= Color(0xFFFFE55A)
)

val mainDarkColor = TestAppColors(
    mainBackground = Color.White,
    mainText = Color(0xFF333333),
    iconTint = Color(0xFF464C5C),
    textSecond = Color(0xFF666666),
    textMinor = Color(0xFF999999),
    button = Color(0xFFE8E9EB),
    tagTop = Color(0xFFD1DEFF),
    tagTopText = Color(0xFF3D6BE3),
    tagCategory= Color(0xFFFCF2DD),
    tagColor= Color(0xFFFFE55A)
)



@Composable
fun TestAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        mainDarkColor
    } else {
        mainLightColor
    }

    CompositionLocalProvider(
        LocaleTestAppColors provides colors,
        content = content)
}