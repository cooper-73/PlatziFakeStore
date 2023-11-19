package com.example.platzifakestore.domain.usecases

import com.example.platzifakestore.data.repositories.ProductsRepository
import com.example.platzifakestore.domain.mappers.ProductMapper
import com.example.platzifakestore.domain.models.Product
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
    suspend fun getAllProducts(): List<Product> {
        return productsRepository.getAllProducts().map { ProductMapper.productModelToProduct(it) }
    }
}