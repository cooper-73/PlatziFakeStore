package com.example.platzifakestore.data.datasources.network.models

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: CategoryModel,
    @SerializedName("images")
    val images: List<String>
)

data class CategoryModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
)