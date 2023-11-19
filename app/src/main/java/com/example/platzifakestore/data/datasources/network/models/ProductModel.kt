package com.example.platzifakestore.data.datasources.network.models

data class ProductModel(
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val category: Category,
    val images: List<String>
)

data class Category(
    val id: Int,
    val name: String,
    val image: String,
)