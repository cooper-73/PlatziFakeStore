package com.example.platzifakestore.data.datasources

import com.example.platzifakestore.data.datasources.network.models.ProductModel

interface ProductsDatasource {
    suspend fun getAllProducts(): List<ProductModel>
    suspend fun getProduct(productId: Int): ProductModel
    suspend fun saveProducts(products: List<ProductModel>)
}