package com.example.platzifakestore.data.datasources.network.models

data class ProductModel(
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val category: CategoryModel,
    val images: List<String>
)

data class CategoryModel(
    val id: Int,
    val name: String,
    val image: String,
)