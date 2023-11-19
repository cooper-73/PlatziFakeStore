package com.example.platzifakestore.data.repositories

import com.example.platzifakestore.data.datasources.network.models.ProductModel

interface ProductsRepository {
    fun getAllProducts(): List<ProductModel>
}