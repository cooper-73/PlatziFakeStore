package com.example.platzifakestore.di

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.datasources.network.RetrofitProductsDatasource
import com.example.platzifakestore.data.datasources.network.services.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DatasourcesModule {

    @Provides
    fun providesRetrofitProductsDatasource(productsService: ProductsService): ProductsDatasource {
        return RetrofitProductsDatasource(productsService)
    }

}