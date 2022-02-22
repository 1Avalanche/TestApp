package com.example.testapp.ui.product_screen.model

sealed class ProductPageEvent {
    object EnterScreen: ProductPageEvent()
//    data class OnPriceClick(val itemId: Int) : ProductPageEvent()
//    data class OnStorageClick(val itemId: Int) : ProductPageEvent()
//    data class OnSuppliesClick(val itemId: Int) : ProductPageEvent()
//    data class OnSaleHistoryClick(val itemId: Int) : ProductPageEvent()
    data class OnAllCharactersClick(val itemId: Int) : ProductPageEvent()
//    data class OnReviewsClick(val itemId: Int) : ProductPageEvent()
//    data class OnItemClick(val itemId: Int) : ProductPageEvent()
}