package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testapp.ui.product_screen.ProductPage
import com.example.testapp.ui.product_screen.ProductPageViewModel
import com.example.testapp.ui.theme.TestAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = true
                    )
                }
                Surface(color = TestAppTheme.colors.mainBackground) {
                    val productPageViewModel = hiltViewModel<ProductPageViewModel>()
                    ProductPage(viewModel = productPageViewModel)
                }
            }
        }
    }
}
