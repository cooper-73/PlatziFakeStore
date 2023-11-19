package com.example.platzifakestore.di

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.repositories.ProductsRepository
import com.example.platzifakestore.data.repositories.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoriesModule {

    @Provides
    fun provideProductRepository(productsDatasource: ProductsDatasource): ProductsRepository {
        return ProductsRepositoryImpl(productsDatasource)
    }
}