package com.example.testapp.di

import com.example.testapp.data.mappers.ProductItemMapper
import com.example.testapp.data.repositories.*
import com.example.testapp.domain.repositories.ProductItemRepository
import com.example.testapp.domain.usecases.GetProductInfoUseCase
import com.example.testapp.domain.usecases.GetRelatedProductsForCurrentProductById
import com.example.testapp.domain.usecases.GetSimilarProductsForCurrentProductById
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideProductItemLocaleDataSource() : ProductItemLocaleDataSource {
        return ProductItemLocaleDataSourceImpl()
    }

    @Provides
    fun provideProductItemRemoteDataSource() : ProductItemRemoteDataSource {
        return ProductItemRemoteDataSourceImpl()
    }

    @Provides
    fun provideProductItemRepository(
        localeDataSource: ProductItemLocaleDataSource,
        remoteDataSource: ProductItemRemoteDataSource
    ) : ProductItemRepository {
        return ProductItemRepositoryImpl(localeDataSource, remoteDataSource)
    }

    @Provides
    fun provideGetProductInfoUseCase(repository: ProductItemRepository) : GetProductInfoUseCase {
        return GetProductInfoUseCase(repository)
    }

    @Provides
    fun provideGetRelatedProductsForCurrentProductById(repository: ProductItemRepository) : GetRelatedProductsForCurrentProductById {
        return GetRelatedProductsForCurrentProductById(repository)
    }

    @Provides
    fun provideGetSimilarProductsForCurrentProductById(repository: ProductItemRepository) : GetSimilarProductsForCurrentProductById {
        return GetSimilarProductsForCurrentProductById(repository)
    }

    @Provides
    fun provideProductItemMapper() : ProductItemMapper {
        return ProductItemMapper
    }
}