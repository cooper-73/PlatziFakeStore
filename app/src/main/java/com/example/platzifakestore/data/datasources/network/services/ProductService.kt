package com.example.platzifakestore.data.datasources.network.services

import com.example.platzifakestore.data.datasources.network.models.ProductModel
import retrofit2.http.GET

interface ProductService {
    @GET("v1/products")
    suspend fun getAllProducts(): List<ProductModel>
}