package com.example.platzifakestore.di

import android.content.Context
import androidx.room.Room
import com.example.platzifakestore.data.datasources.database.core.PlatziFakeStoreDatabase
import com.example.platzifakestore.data.datasources.database.daos.CategoriesDao
import com.example.platzifakestore.data.datasources.database.daos.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DATABASE_NAME = "platzi_fake_store_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): PlatziFakeStoreDatabase {
        return Room.databaseBuilder(context, PlatziFakeStoreDatabase::class.java, DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideProductsDao(database: PlatziFakeStoreDatabase): ProductsDao {
        return database.getProductsDao()
    }

    @Singleton
    @Provides
    fun provideCategoriesDao(database: PlatziFakeStoreDatabase): CategoriesDao {
        return database.getCategoriesDao()
    }
}