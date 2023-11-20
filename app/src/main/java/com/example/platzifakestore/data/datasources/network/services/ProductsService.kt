package com.example.platzifakestore.data.datasources.network.services

import com.example.platzifakestore.data.datasources.network.models.ProductModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsService {
    @GET("v1/products")
    suspend fun getAllProducts(): List<ProductModel>

    @GET("v1/products/{productId}")
    suspend fun getProduct(@Path("productId") productId: Int): ProductModel
}