package com.example.platzifakestore.di

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.datasources.database.RoomProductsDatasource
import com.example.platzifakestore.data.datasources.database.daos.CategoriesDao
import com.example.platzifakestore.data.datasources.database.daos.ProductsDao
import com.example.platzifakestore.data.datasources.network.RetrofitProductsDatasource
import com.example.platzifakestore.data.datasources.network.services.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object DatasourcesModule {

    @Provides
    @Named("retrofitProductsDatasource")
    fun providesRetrofitProductsDatasource(productsService: ProductsService): ProductsDatasource {
        return RetrofitProductsDatasource(productsService)
    }

    @Provides
    @Named("roomProductsDatasource")
    fun providesRoomProductsDatasource(
        productsDao: ProductsDao,
        categoriesDao: CategoriesDao
    ): ProductsDatasource {
        return RoomProductsDatasource(productsDao, categoriesDao)
    }

}