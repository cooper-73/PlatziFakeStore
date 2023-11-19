package com.example.platzifakestore.data.datasources.network

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.datasources.network.models.ProductModel
import com.example.platzifakestore.data.datasources.network.services.ProductsService

class RetrofitProductsDatasource(private val productsService: ProductsService) : ProductsDatasource {
    override suspend fun getAllProducts(): List<ProductModel> {
        return productsService.getAllProducts()
    }

}