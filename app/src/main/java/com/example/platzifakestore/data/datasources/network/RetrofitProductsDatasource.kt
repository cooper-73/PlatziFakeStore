package com.example.platzifakestore.data.datasources.network

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.datasources.network.core.RetrofitClient
import com.example.platzifakestore.data.datasources.network.models.ProductModel

class RetrofitProductsDatasource : ProductsDatasource {
    override suspend fun getAllProducts(): List<ProductModel> {
        return RetrofitClient.productsService.getAllProducts()
    }

}