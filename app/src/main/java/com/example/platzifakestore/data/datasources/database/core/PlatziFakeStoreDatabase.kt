package com.example.platzifakestore.data.datasources.database.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.platzifakestore.data.datasources.database.daos.CategoriesDao
import com.example.platzifakestore.data.datasources.database.daos.ProductsDao
import com.example.platzifakestore.data.datasources.database.entities.ProductEntity

@Database(entities = [ProductEntity::class, CategoriesDao::class], version = 1)
abstract class PlatziFakeStoreDatabase : RoomDatabase() {
    abstract fun getProductsDao(): ProductsDao

    abstract fun getCategoriesDao(): CategoriesDao
}