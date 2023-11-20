package com.example.platzifakestore.data.repositories

import com.example.platzifakestore.data.datasources.network.models.ProductModel

interface ProductsRepository {
    suspend fun getAllProducts(): List<ProductModel>
    suspend fun getProduct(productId: Int): ProductModel
    suspend fun filterProductsByTitle(title: String): List<ProductModel>
}