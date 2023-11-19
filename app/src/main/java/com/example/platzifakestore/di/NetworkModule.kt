package com.example.platzifakestore.di

import com.example.platzifakestore.data.datasources.network.core.RetrofitClient
import com.example.platzifakestore.data.datasources.network.services.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RetrofitClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }
}