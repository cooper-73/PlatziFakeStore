package com.example.platzifakestore.di

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.repositories.ProductsRepository
import com.example.platzifakestore.data.repositories.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object RepositoriesModule {

    @Provides
    fun provideProductRepository(
        @Named("retrofitProductsDatasource") networkProductsDatasource: ProductsDatasource,
        @Named("roomProductsDatasource") databaseProductsDatasource: ProductsDatasource
    ): ProductsRepository {
        return ProductsRepositoryImpl(networkProductsDatasource, databaseProductsDatasource)
    }
}