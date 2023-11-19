package com.example.platzifakestore.data.datasources.network.core

import com.example.platzifakestore.data.datasources.network.services.ProductsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.escuelajs.co/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val productsService: ProductsService by lazy {
        retrofit.create(ProductsService::class.java)
    }
}