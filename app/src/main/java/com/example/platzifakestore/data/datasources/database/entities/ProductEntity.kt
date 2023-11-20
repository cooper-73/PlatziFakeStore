package com.example.platzifakestore.data.datasources.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["id"],
        childColumns = ["category_id"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["category_id"])],
)
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("price")
    val price: Int,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("category_id")
    val categoryId: Int,
    @ColumnInfo("images")
    val images: List<String>
)