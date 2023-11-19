package com.example.platzifakestore.data.datasources

import com.example.platzifakestore.data.datasources.network.models.ProductModel

interface ProductsDatasource {
    fun getAllProducts(): List<ProductModel>
}