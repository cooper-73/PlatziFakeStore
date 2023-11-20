package com.example.platzifakestore.data.datasources.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.platzifakestore.data.datasources.database.entities.ProductEntity

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Transaction
    @Query(
        "SELECT products.category_id AS categoryId, products.*, categories.name AS categoryName, categories.image AS categoryImage " +
                "FROM products INNER JOIN categories ON products.category_id = categories.id"
    )
    suspend fun getProductsWithCategory(): List<ProductWithCategory>

    @Transaction
    @Query(
        "SELECT products.category_id AS categoryId, products.*, categories.name AS categoryName, categories.image AS categoryImage " +
                "FROM products INNER JOIN categories ON products.category_id = categories.id " +
                "WHERE products.id = :productId"
    )
    suspend fun getProductWithCategory(productId: Int): ProductWithCategory

    @Transaction
    @Query(
        "SELECT products.category_id AS categoryId, products.*, categories.name AS categoryName, categories.image AS categoryImage " +
                "FROM products INNER JOIN categories ON products.category_id = categories.id " +
                "WHERE LOWER(products.title) LIKE '%' || LOWER(:title) || '%'"
    )
    suspend fun filterProductsByTitle(title: String): List<ProductWithCategory>

    @Transaction
    @Query(
        "SELECT products.category_id AS categoryId, products.*, categories.name AS categoryName, categories.image AS categoryImage " +
                "FROM products INNER JOIN categories ON products.category_id = categories.id ORDER BY " +
                "CASE WHEN :isAsc = 1 THEN products.price END ASC, " +
                "CASE WHEN :isAsc = 0 THEN products.price END DESC"
    )
    suspend fun getProductsSortedByPrice(isAsc: Boolean): List<ProductWithCategory>

}