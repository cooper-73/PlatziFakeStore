package com.example.platzifakestore.data.repositories

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.datasources.network.models.ProductModel

class ProductsRepositoryImpl(
    private val networkDataSource: ProductsDatasource,
    private val databaseDatasource: ProductsDatasource
) :
    ProductsRepository {
    override suspend fun getAllProducts(): List<ProductModel> {
        return networkDataSource.getAllProducts()
    }

    override suspend fun getProduct(productId: Int): ProductModel {
        return networkDataSource.getProduct(productId)
    }
}