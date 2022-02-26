package com.example.testapp.ui.product_screen.model

sealed class ProductPageEvent {
    object EnterScreen: ProductPageEvent()
    object ChangeShowAllCharacters : ProductPageEvent()
    object RefreshData : ProductPageEvent()
}