package com.example.testapp.ui.product_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.mappers.ProductItemMapper
import com.example.testapp.domain.common.EventHandler
import com.example.testapp.domain.common.ResponseWrapper
import com.example.testapp.domain.usecases.GetProductInfoUseCase
import com.example.testapp.domain.usecases.GetRelatedProductsForCurrentProductById
import com.example.testapp.domain.usecases.GetSimilarProductsForCurrentProductById
import com.example.testapp.ui.product_screen.model.ProductPageEvent
import com.example.testapp.ui.product_screen.model.ProductPageViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
            is ProductPageViewState.Display -> reduce(event, currentState)
            else -> { }
        }

    }

    fun reduce(event: ProductPageEvent, currentState: ProductPageViewState.Display) {
        if (event == ProductPageEvent.ChangeShowAllCharacters) {
            _pageState.postValue(currentState.copy(showAllCharacter = !currentState.showAllCharacter))
        }
    }

    fun getData() {
        viewModelScope.launch {
            val productInfo = getProductInfoUseCase.invoke(1)
            val similarProducts = getSimilarProductsForCurrentProductById.invoke(1)
            val relatedProducts = getRelatedProductsForCurrentProductById.invoke(1)
            if (productInfo is ResponseWrapper.Success
                && similarProducts is ResponseWrapper.Success
                && relatedProducts is ResponseWrapper.Success
                && productInfo.value != null) {

                _pageState.postValue(ProductPageViewState.Display(
                    productMapper.productItemToProductModel(productInfo.value),
                    productMapper.productItemToProductWithCropInfo(similarProducts.value),
                    productMapper.productItemToProductWithCropInfo(relatedProducts.value),
                    false
                ))
            }
        }
    }
}