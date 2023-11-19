package com.example.platzifakestore.domain.mappers

import com.example.platzifakestore.data.datasources.network.models.ProductModel
import com.example.platzifakestore.domain.models.Category
import com.example.platzifakestore.domain.models.Product

object ProductMapper {
    fun productModelToProduct(productModel: ProductModel): Product {
        return Product(
            id = productModel.id,
            title = productModel.title,
            price = productModel.price,
            description = productModel.description,
            category = Category(
                id = productModel.category.id,
                name = productModel.category.name,
                image = productModel.category.image
            ),
            images = productModel.images
        )
    }
}