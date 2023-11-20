package com.example.platzifakestore.data.datasources.mappers

import com.example.platzifakestore.data.datasources.database.entities.CategoryEntity
import com.example.platzifakestore.data.datasources.network.models.CategoryModel

object CategoryModelMapper {
    fun categoryModelToCategoryEntity(categoryModel: CategoryModel): CategoryEntity {
        return with(categoryModel) {
            CategoryEntity(
                id = this.id,
                name = this.name,
                image = this.image
            )
        }
    }
}