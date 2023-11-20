package com.example.platzifakestore.data.datasources.database.core

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.platzifakestore.data.datasources.database.converters.ListOfStringsConverter
import com.example.platzifakestore.data.datasources.database.daos.CategoriesDao
import com.example.platzifakestore.data.datasources.database.daos.ProductsDao
import com.example.platzifakestore.data.datasources.database.entities.CategoryEntity
import com.example.platzifakestore.data.datasources.database.entities.ProductEntity

@Database(entities = [ProductEntity::class, CategoryEntity::class], version = 1)
@TypeConverters(ListOfStringsConverter::class)
abstract class PlatziFakeStoreDatabase : RoomDatabase() {
    abstract fun getProductsDao(): ProductsDao

    abstract fun getCategoriesDao(): CategoriesDao
}