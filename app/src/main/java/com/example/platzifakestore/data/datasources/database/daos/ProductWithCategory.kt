package com.example.platzifakestore.data.datasources.database.daos

data class ProductWithCategory(
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val categoryId: Int,
    val images: List<String>,
    val categoryName: String,
    val categoryImage: String,
)
