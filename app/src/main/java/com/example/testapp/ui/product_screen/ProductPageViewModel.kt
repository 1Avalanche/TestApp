package com.example.testapp.ui.product_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.mappers.ProductItemMapper
import com.example.testapp.domain.common.EventHandler
import com.example.testapp.domain.usecases.GetProductInfoUseCase
import com.example.testapp.domain.usecases.GetRelatedProductsForCurrentProductById
import com.example.testapp.domain.usecases.GetSimilarProductsForCurrentProductById
import com.example.testapp.ui.product_screen.model.ProductPageEvent
import com.example.testapp.ui.product_screen.model.ProductPageViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductPageViewModel @Inject constructor(
    private val getProductInfoUseCase: GetProductInfoUseCase,
    private val getSimilarProductsForCurrentProductById: GetSimilarProductsForCurrentProductById,
    private val getRelatedProductsForCurrentProductById: GetRelatedProductsForCurrentProductById,
    private val productMapper: ProductItemMapper
) : ViewModel(), EventHandler<ProductPageEvent> {

    private val _pageState: MutableLiveData<ProductPageViewState> = MutableLiveData(ProductPageViewState.Loading)
    val pageState: LiveData<ProductPageViewState> = _pageState

    override fun obtainEvent(event: ProductPageEvent) {
        val currentState = _pageState.value
        when (currentState) {

        }

    }

    fun reduce(event: ProductPageEvent, currentState: ProductPageViewState.Loading) {

    }


//
//    fun getData(productId: Int) {
//        viewModelScope.launch {
//            val dataList = mutableListOf<ProductPageData>()
//
//            val product = getProductInfoUseCase.invoke(productId)
//            when (product) {
//                is ResponseWrapper.Success -> {
//                    product.value?.let {
//                        dataList.add(
//                            productMapper.productItemToProductItemEntity(it)
//                        )
//                    }
//                }
//                else -> {}
//            }
//
//        }
//    }
}