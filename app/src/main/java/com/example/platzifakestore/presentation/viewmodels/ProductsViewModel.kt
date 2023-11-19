package com.example.platzifakestore.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.platzifakestore.domain.models.Category
import com.example.platzifakestore.domain.models.Product

class ProductsViewModel : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun getAllProducts() {
        _products.postValue(
            listOf(
                Product(
                    id = 4,
                    title = "Handmade Fresh Table",
                    price = 687,
                    description = "Andy shoes are designed to keeping in...",
                    category = Category(
                        id = 5,
                        name = "Others",
                        image = "https://placeimg.com/640/480/any?r=0.591926261873231"
                    ),
                    images = listOf(
                        "https://placeimg.com/640/480/any?r=0.9178516507833767",
                        "https://placeimg.com/640/480/any?r=0.9300320592588625",
                        "https://placeimg.com/640/480/any?r=0.8807778235430017"
                    )
                )
            )
        )
    }
}