package com.example.platzifakestore.domain.usecases

import com.example.platzifakestore.data.repositories.ProductsRepository
import com.example.platzifakestore.domain.mappers.ProductMapper
import com.example.platzifakestore.domain.models.Product
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
    suspend fun getAllProducts(): List<Product> {
        return productsRepository.getAllProducts().map { ProductMapper.productModelToProduct(it) }
    }

    suspend fun getProduct(productId: Int): Product {
        return ProductMapper.productModelToProduct(productsRepository.getProduct(productId))
    }

    suspend fun filterProductsByTitle(title: String): List<Product> {
        return productsRepository.filterProductsByTitle(title)
            .map { ProductMapper.productModelToProduct(it) }
    }
}