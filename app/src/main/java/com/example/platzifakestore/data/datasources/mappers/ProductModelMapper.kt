package com.example.platzifakestore.data.datasources.mappers

import com.example.platzifakestore.data.datasources.database.daos.ProductWithCategory
import com.example.platzifakestore.data.datasources.database.entities.ProductEntity
import com.example.platzifakestore.data.datasources.network.models.CategoryModel
import com.example.platzifakestore.data.datasources.network.models.ProductModel

object ProductModelMapper {
    fun productWithCategoryToProductModel(productWithCategoryToProductModel: ProductWithCategory): ProductModel {
        return with(productWithCategoryToProductModel) {
            ProductModel(
                id = this.id,
                title = this.title,
                price = this.price,
                description = this.description,
                category = CategoryModel(
                    id = this.categoryId,
                    name = this.categoryName,
                    image = this.categoryImage
                ),
                images = this.images
            )
        }
    }

    fun productModelToProductEntity(productModel: ProductModel): ProductEntity {
        return with(productModel) {
            ProductEntity(
                id = this.id,
                title = this.title,
                price = this.price,
                description = this.description,
                categoryId = this.category.id,
                images = this.images
            )
        }
    }
}