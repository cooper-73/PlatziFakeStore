package com.example.platzifakestore.data.datasources.database

import com.example.platzifakestore.data.datasources.ProductsDatasource
import com.example.platzifakestore.data.datasources.database.daos.CategoriesDao
import com.example.platzifakestore.data.datasources.database.daos.ProductsDao
import com.example.platzifakestore.data.datasources.mappers.CategoryModelMapper
import com.example.platzifakestore.data.datasources.mappers.ProductModelMapper
import com.example.platzifakestore.data.datasources.network.models.ProductModel

class RoomProductsDatasource(
    private val productsDao: ProductsDao,
    private val categoriesDao: CategoriesDao
) : ProductsDatasource {
    override suspend fun getAllProducts(): List<ProductModel> {
        return productsDao.getProductsWithCategory()
            .map { ProductModelMapper.productWithCategoryToProductModel(it) }
    }

    override suspend fun getProduct(productId: Int): ProductModel {
        return ProductModelMapper.productWithCategoryToProductModel(
            productsDao.getProductWithCategory(
                productId
            )
        )
    }

    override suspend fun saveProducts(products: List<ProductModel>) {
        categoriesDao.insertCategories(categories = products.map {
            CategoryModelMapper.categoryModelToCategoryEntity(
                it.category
            )
        })

        productsDao.insertProducts(products = products.map {
            ProductModelMapper.productModelToProductEntity(
                it
            )
        })
    }

    override suspend fun filterProductsByTitle(title: String): List<ProductModel> {
        return productsDao.filterProductsByTitle(title)
            .map { ProductModelMapper.productWithCategoryToProductModel(it) }
    }
}