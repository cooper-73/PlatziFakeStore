package com.example.platzifakestore.data.repositories

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.datasources.network.models.ProductModel

class ProductsRepositoryImpl(
    private val networkDataSource: ProductsDatasource,
    private val databaseDatasource: ProductsDatasource
) :
    ProductsRepository {
    override suspend fun getAllProducts(): List<ProductModel> {
        val products = networkDataSource.getAllProducts()
        databaseDatasource.saveProducts(products)
        return products
    }

    override suspend fun getProduct(productId: Int): ProductModel {
        return databaseDatasource.getProduct(productId)
    }

    override suspend fun filterProductsByTitle(title: String): List<ProductModel> {
        return databaseDatasource.filterProductsByTitle(title)
    }
}